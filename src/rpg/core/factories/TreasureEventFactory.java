package rpg.core.factories;

import rpg.core.dungeon.events.treasure.TreasureType;

public class TreasureEventFactory extends AbstractEventFactory {
	public TreasureEventFactory() {
		params = TreasureType.LARGE_TREASURE;
	}
}
