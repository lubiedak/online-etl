package org.online.etl.model.abstractions;

public interface ETLItem {
  void extract(Data input);

  void transform();

  Data load();
  
}
