package org.online.etl.model.processors;

import org.online.etl.model.abstractions.Data;
import org.online.etl.model.abstractions.ETLItem;

public class SimpleMapper implements ETLItem {

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
}
