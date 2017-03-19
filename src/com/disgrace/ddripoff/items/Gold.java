package com.disgrace.ddripoff.items;

public class Gold extends Treasure {
	public Gold() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Gold";
		description = "Shiny!!!";
		cost = 1;

		inventoryFitQuantity = 1500;
		dropRate = 75;
	}

}
