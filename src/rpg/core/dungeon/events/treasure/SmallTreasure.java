package rpg.core.dungeon.events.treasure;

import rpg.core.items.LootType;

public class SmallTreasure extends Treasure {
	public SmallTreasure() {
		lootType = LootType.SMALL_LOOT;
	}
}
