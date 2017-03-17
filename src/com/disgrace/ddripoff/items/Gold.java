package com.disgrace.ddripoff.items;

public class Gold extends Treasure {
	@Override
	protected void initItem() {
		name = "Gold";
		description = "Shiny!!!";
		cost = 1;
		maxSpawnQuanitity = 5000;
		inventoryFitQuantity = 1500;
		dropRate = 75;
	}

}
