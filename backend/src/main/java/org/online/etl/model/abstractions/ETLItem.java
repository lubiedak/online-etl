package org.online.etl.model.abstractions;

public interface ETLItem {
	void extract(Input input);

	void transform();

	Output load();
}
