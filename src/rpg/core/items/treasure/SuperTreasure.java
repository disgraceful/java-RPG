package rpg.core.items.treasure;

import javax.xml.bind.annotation.XmlRootElement;


public class SuperTreasure extends Treasure{
	@Override
	protected void initItem() {
		name = "Super Treasure";
		description = "So uber shiny!";
		cost = 1;
		maxSpawnedQuantity = 3;
		stackQuantity = 3;
	}
}
