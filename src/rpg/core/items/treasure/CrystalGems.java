package rpg.core.items.treasure;

import rpg.core.items.ItemRarity;

public class CrystalGems extends  Treasure{
	public CrystalGems() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Crystal Gems";
		description = "They shine cheerly bright, but will darken surely";
		cost = 1500;
		stackQuantity = 5;
		maxSpawnedQuantity = 2;
		quantityMultiplier = 1;
		itemType = TreasureType.CRYSTAL_GEMS;
		rarity= ItemRarity.RARE;
	}
}
