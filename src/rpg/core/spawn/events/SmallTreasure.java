package rpg.core.spawn.events;

import rpg.core.items.LootType;

public class SmallTreasure extends Treasure {
	public SmallTreasure() {
		lootType = LootType.SMALL_LOOT;
	}
}
