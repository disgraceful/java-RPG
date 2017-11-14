package rpg.core.items.treasure;

public class Gold extends Treasure {
	public Gold() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Gold";
		description = "Shiny!!!";
		cost = 1;
		stackQuantity = 1500;
		maxSpawnedQuantity = 3500;
	}

}
