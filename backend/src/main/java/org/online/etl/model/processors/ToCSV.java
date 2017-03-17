package org.online.etl.model.processors;

import java.util.List;

import org.online.etl.model.abstractions.Data;
import org.online.etl.model.abstractions.ETLItem;
import org.online.etl.model.abstractions.Entity;

public class ToCSV implements ETLItem {

  Data data;

  @Override
  public void extract(Data input) {
    // probably some validation here
    data = input;
  }

  @Override
  public void transform() {

  }

  @Override
  public Data load() {
    return null;
  }

  @Override
  public String asOutput() {
    // TODO Think about using StringBuilder
    String output = "";
    List<Entity> entities = data.getEntities();

    int rowSize = (int) entities.stream().filter(e -> e.getParentId() == -1).count();
    for (int i = 0; i < rowSize; ++i) {
      output += entities.get(i).getKey().equals("") 
              ? entities.get(i).getValue() 
              : entities.get(i).getKey();
              
      output += (i != rowSize - 1) ? ";" : "\n";
    }
    for (int i = rowSize; i < entities.size(); ++i) {
      output += entities.get(i).getValue();
      output += ((i + 1) % rowSize != 0)
                ? ";"
                : ((i + 1 < entities.size()) 
                    ? "\n"
                    : "");
    }
    return output;
  }

}
