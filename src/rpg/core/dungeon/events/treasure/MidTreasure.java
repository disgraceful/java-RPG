package rpg.core.dungeon.events.treasure;

import rpg.core.items.LootType;

public class MidTreasure extends Treasure {
	public MidTreasure() {
		super();
		lootType = LootType.MEDIUM_LOOT;
		spawn();
	}
}
