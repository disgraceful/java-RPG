package rpg.core.factories;

import rpg.core.dungeon.DungeonType;
import rpg.core.dungeon.events.SpawnEvent;
import rpg.core.dungeon.events.fight.FightType;

public class FightEventFactory extends AbstractEventFactory {
	public FightEventFactory() {
		params = FightType.MID;
	}
	
	@Override
	public SpawnEvent createEvent(DungeonType restriction) {
		return FightType.MID.getRandomizedEvent(restriction);
	}
}
