package org.online.etl.model.abstractions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVEntititiesBuilder { // think about relationship to entity
									// builder

	Data data = new Data();
	long currentId = 0L;
	// These params should be configurable
	String delim = ";";
	boolean firstRowKeys = true;
	boolean fixedNOfColumns = false; // Future - idea that user defines number
										// of columns
	int nOfColumns = 0;

	void load(String input) {
		List<String[]> table = readInput(input);
		if (!firstRowKeys)
			createFirstRow();

		for (String[] row : table) {
			addRow(row);
		}
	}

	Entity build(String entity) {
		return null;
	}

	private void createFirstRow() {
		for (int i = 0; i < nOfColumns; ++i) {
			data.addEntity(new Entity(currentId, -1L, "Col" + i, "String", "", null));
		}
		currentId = nOfColumns;
	}

	private void addRow(String[] row) {
		for (int i = 0; i < nOfColumns; ++i) {
			data.addEntity(new Entity(currentId, (long) i, "", "String", "", null));
		}
	}

	private List<String[]> readInput(String input) {
		String[] lines = input.split("\\r?\\n");

		nOfColumns = firstRowKeys ? lines[0].split(delim).length : 0;

		return fixTable(createTable(lines));
	}

	private List<String[]> createTable(String[] lines) {
		List<String[]> table = new ArrayList<String[]>();
		for (String line : lines) {
			String[] row = line.split(delim);
			if (!firstRowKeys && row.length > nOfColumns)
				nOfColumns = row.length;
			table.add(row);
		}
		return table;
	}

	private List<String[]> fixTable(List<String[]> table) {
		List<String[]> tableFixed = new ArrayList<String[]>();
		for (String[] row : table) {

			tableFixed.add(addOrCutRow(row));
		}
		return tableFixed;
	}

	private String[] addOrCutRow(String[] row) {
		if (row.length == nOfColumns)
			return row;

		String[] fixedRow = new String[nOfColumns];
		Arrays.fill(fixedRow, "");

		int end = row.length > nOfColumns ? nOfColumns : row.length;
		for (int i = 0; i < end; ++i)
			fixedRow[i] = row[i];

		return fixedRow;
	}
}
