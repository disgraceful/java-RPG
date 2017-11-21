package rpg.core.spawn.events;

import rpg.core.factories.LootFactory;

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
