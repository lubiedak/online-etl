package org.online.etl.model.abstractions;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Entity {
	long id;
	long parentId;
	String key;
	String valueType;
	String value;
	
	Map<String, String> attributes;
}
