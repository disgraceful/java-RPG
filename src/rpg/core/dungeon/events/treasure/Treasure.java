package rpg.core.dungeon.events.treasure;

import rpg.core.dungeon.events.SpawnEvent;
import rpg.core.dungeon.events.SpawnableEventType;
import rpg.core.factories.LootFactory;
import rpg.core.items.Item;

public class Treasure extends SpawnEvent {
	public Treasure() {
		spawnType = SpawnableEventType.TREASURE;
		
	}
	
	@Override
	public void trigger() {
		if (!triggered) {

		}
		// TODO open loot if yes add to DungSession Inventory
	}

	@Override
	public void spawn() {
		loot = LootFactory.spawnLoot(lootType);
	}
}
