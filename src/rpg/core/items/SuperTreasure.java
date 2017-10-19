package rpg.core.items;

import javax.xml.bind.annotation.XmlRootElement;


public class SuperTreasure extends Treasure{
	@Override
	protected void initItem() {
		name = "Super Treasure";
		description = "So uber shiny!";
		cost = 1;
		maxSpawnQuanitity = 5000;
		inventoryFitQuantity = 3;
		dropRate = 35;
	}
}
