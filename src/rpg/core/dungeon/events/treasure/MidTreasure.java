package rpg.core.dungeon.events.treasure;

import rpg.core.items.LootType;

public class MidTreasure extends Treasure {
	public MidTreasure() {
		lootType = LootType.MEDIUM_LOOT;
	}
}
