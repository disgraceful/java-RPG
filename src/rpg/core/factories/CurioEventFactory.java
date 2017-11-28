package rpg.core.factories;

import rpg.core.dungeon.DungeonType;
import rpg.core.dungeon.events.SpawnEvent;
import rpg.core.dungeon.events.curio.CurioType;

public class CurioEventFactory extends AbstractEventFactory {
	public CurioEventFactory() {
		params = CurioType.CORRUPTED_FOUNTAIN;
	}
	
	@Override
	public SpawnEvent createEvent(DungeonType restriction) {
		return CurioType.getRandomEventByRestriction(restriction);		
	}
}
