package org.online.etl.model.abstractions;

import java.util.Set;

public /* TODO abstract*/ class Data {
	String type; // TODO hierarchical or table
	Set<Entity> entities;
	
	
	
	void addEntity(Entity entity){
		entities.add(entity);
	}
}
