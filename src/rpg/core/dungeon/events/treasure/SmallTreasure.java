package rpg.core.dungeon.events.treasure;

import rpg.core.items.LootType;

public class SmallTreasure extends Treasure {
	public SmallTreasure() {
		super();
		lootType = LootType.SMALL_LOOT;
		spawn();
	}
}
