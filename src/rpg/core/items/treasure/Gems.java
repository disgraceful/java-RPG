package rpg.core.items.treasure;

import javax.xml.bind.annotation.XmlRootElement;


public class Gems extends Treasure {
	@Override
	protected void initItem() {
		name = "Jewels";
		description = "Very much shiny!";
		cost = 1;
		maxSpawnQuanitity = 5000;
		stackQuantity = 8;
		dropRate = 45;
	}

	public Gems() {
		initItem();
	}
}
