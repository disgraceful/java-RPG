package com.disgrace.ddripoff.items;

public class Food extends Consumable {
	public Food() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Food";
		description = "Yummy-yummy";
		cost = 5;
		maxSpawnQuanitity = 24;
		inventoryFitQuantity = 24;
	}

}
