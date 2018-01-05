package rpg.core.dungeon.events.treasure;

import rpg.core.dungeon.events.SpawnEvent;
import rpg.core.dungeon.events.SpawnableEventType;
import rpg.core.factories.LootFactory;
import rpg.core.items.Item;
import rpg.core.session.DungeonSession;

public class Treasure extends SpawnEvent {
	public Treasure() {
		spawnType = SpawnableEventType.TREASURE;
		
	}
	
	@Override
	public void trigger() {
		if (!triggered) {
			DungeonSession.getSession().collectLoot(loot);
		}
	}

	@Override
	public void spawn() {
		loot = LootFactory.spawnLoot(lootType);
	}
}
