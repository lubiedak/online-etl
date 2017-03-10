package org.online.etl.model.abstractions;

import java.util.ArrayList;
import java.util.List;

public /* TODO abstract */ class Data {
  String type; // TODO hierarchical or table
  List<Entity> entities = new ArrayList<Entity>();

  void addEntity(Entity entity) {
    entities.add(entity);
  }

  @Override
  public String toString() {
    String str = "Data [type=" + type + ", entities:\n";
    for(Entity e : entities)
      str += e + "\n";
    return str;
  }
  
}
