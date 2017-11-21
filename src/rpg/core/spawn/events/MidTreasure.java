package rpg.core.spawn.events;

import rpg.core.items.LootType;

public class MidTreasure extends Treasure {
	public MidTreasure() {
		lootType = LootType.MEDIUM_LOOT;
	}
}
