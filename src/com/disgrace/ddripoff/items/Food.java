package com.disgrace.ddripoff.items;

public class Food extends Consumable {
	@Override
	protected void initItem() {
		name = "Food";
		description = "Yummy-yummy";
		cost = 5;
		inventoryFitQuantity = 24;
	}
	
	public Food(){
		initItem();
	}
}
