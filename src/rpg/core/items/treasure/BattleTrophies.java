package rpg.core.items.treasure;

import rpg.core.items.ItemRarity;

public class BattleTrophies  extends Treasure{
	public BattleTrophies() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Battle Trophies";
		description = "Deadmen do not need things, while living can make a fortune";
		cost = 500;
		stackQuantity = 10;
		maxSpawnedQuantity = 4;
		quantityMultiplier = 1;
		itemType = TreasureType.BATTLE_TROPHIES;
		rarity= ItemRarity.UNCOMMON;
	}
}
