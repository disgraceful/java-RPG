package rpg.core.dungeon.events.treasure;

import rpg.core.items.LootType;

public class LargeTreasure extends Treasure {
	public LargeTreasure() {
		super();
		lootType = LootType.LARGE_LOOT;
		spawn();
	}
}
