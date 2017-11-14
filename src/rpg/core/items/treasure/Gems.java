package rpg.core.items.treasure;

public class Gems extends Treasure {
	@Override
	protected void initItem() {
		name = "Jewels";
		description = "Very much shiny!";
		cost = 1;
		maxSpawnedQuantity = 5000;
		stackQuantity = 8;
	}

	public Gems() {
		initItem();
	}
}
