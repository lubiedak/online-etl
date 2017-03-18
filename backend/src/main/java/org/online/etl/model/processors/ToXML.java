package org.online.etl.model.processors;

import org.online.etl.model.abstractions.Data;
import org.online.etl.model.abstractions.ETLItem;
import org.online.etl.model.abstractions.EndETLItem;

public class ToXML implements ETLItem, EndETLItem {

  @Override
  public void extract(Data input) {
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
    // TODO Auto-generated method stub
    return null;
  }

}
