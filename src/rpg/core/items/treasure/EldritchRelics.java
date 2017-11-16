package rpg.core.items.treasure;

import rpg.core.items.ItemRarity;

public class EldritchRelics extends Treasure {

	public EldritchRelics() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Eldritch Relics";
		description = "Horrendous and malformed things remains of something ancient, valued higly by those seeking truth";
		cost = 3000;
		stackQuantity = 1;
		maxSpawnedQuantity = 1;
		quantityMultiplier = 1;
		itemType = TreasureType.ELDRITCH_RELICS;
		rarity = ItemRarity.EPIC;
	}
}
