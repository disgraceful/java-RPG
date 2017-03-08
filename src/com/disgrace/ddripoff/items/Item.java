package com.disgrace.ddripoff.items;

public abstract class Item {
	protected String name;
	protected String description;
	
	public String getName(){
		return name;
	}
	
	void setName(String value){
		name = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Item spawnItem(SpawnableItem item){
		return item.getItemToSpawn();
	}
}
