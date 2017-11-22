package rpg.core.factories;

import rpg.core.dungeon.events.fight.FightType;

public class FightEventFactory extends AbstractEventFactory {
	public FightEventFactory() {
		params = FightType.MID;
	}
}
