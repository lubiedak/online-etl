package org.online.etl.model.abstractions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Entity {
	long id;
	long parentId;
	String key;
	String valueType;
	String value;
}
