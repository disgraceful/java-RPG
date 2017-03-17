package com.disgrace.ddripoff.items;

public abstract class Item {
	protected String name;
	protected String description;
	protected int cost;
	protected int spawnQuanitity;
	protected int inventoryFitQuantity;
	protected int dropRate;

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
	
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getSpawnQuanitity() {
		return spawnQuanitity;
	}
	public void setSpawnQuanitity(int spawnQuanitity) {
		this.spawnQuanitity = spawnQuanitity;
	}
	public int getInventoryFitQuantity() {
		return inventoryFitQuantity;
	}
	public void setInventoryFitQuantity(int inventoryFitQuantity) {
		this.inventoryFitQuantity = inventoryFitQuantity;
	}
	public int getDropRate() {
		return dropRate;
	}
	public void setDropRate(int dropRate) {
		this.dropRate = dropRate;
	}
	
	

}
 