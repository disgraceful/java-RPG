package rpg.core.factories;

import rpg.core.dungeon.DungeonType;
import rpg.core.dungeon.events.SpawnEvent;
import rpg.core.dungeon.events.SpawnEventParams;

public class AbstractEventFactory { 
	protected SpawnEventParams params;
	public SpawnEvent createEvent(DungeonType restriction) {
		return params.getRandomizedEvent();
	}
}
