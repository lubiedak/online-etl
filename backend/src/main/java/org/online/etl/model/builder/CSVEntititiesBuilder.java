package org.online.etl.model.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.online.etl.model.abstractions.Data;
import org.online.etl.model.abstractions.Entity;

public class CSVEntititiesBuilder implements EntityBuilder{

  Data data = new Data();
  long currentId = 0L;
  String delim = ";";
  boolean firstRowKeys = true;
  int nOfColumns = 0;

  @Override
  public Data build(String input) {
    List<String[]> table = readInput(input);
    createFirstRow(table);

    for (String[] row : table) {
      if (row == table.get(0))
        continue;
      addRow(row);
    }
    return data;
  }

  private void createFirstRow(List<String[]> table) {
    String[] firstRow = firstRowKeys ? table.get(0) : createArtificialFirstRow();
    for (int i = 0; i < nOfColumns; ++i) {
      data.addEntity(new Entity(currentId++, -1L, firstRow[i], "String", "", null));
    }
  }

  private String[] createArtificialFirstRow() {
    String[] row = new String[nOfColumns];
    for (int i = 0; i < nOfColumns; ++i) {
      row[i] = "Col" + i;
    }
    return row;
  }

  private void addRow(String[] row) {
    for (int i = 0; i < nOfColumns; ++i) {
      data.addEntity(new Entity(currentId++, (long) i, "", "String", row[i], null));
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
