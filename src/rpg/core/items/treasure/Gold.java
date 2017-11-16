package rpg.core.items.treasure;

import rpg.core.items.ItemRarity;

public class Gold extends Treasure {
	public Gold() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Gold";
		description = "Root of all malice";
		cost = 1;
		stackQuantity = 1500;
		maxSpawnedQuantity = 3500;
		quantityMultiplier = 2;
		itemType = TreasureType.GOLD;
		rarity= ItemRarity.COMMON;
	}

}
