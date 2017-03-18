package org.online.etl.model.builder;

import org.online.etl.model.abstractions.Data;

public interface EntityBuilder {
  Data build(String input);
}
