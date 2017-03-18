package com.disgrace.ddripoff.items;

public class Jewels extends Treasure {
	@Override
	protected void initItem() {
		name = "Jewels";
		description = "Very much shiny!";
		cost = 1;
		maxSpawnQuanitity = 5000;
		inventoryFitQuantity = 8;
		dropRate = 45;
	}

	public Jewels() {
		initItem();
	}
}
