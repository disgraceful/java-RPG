package rpg.core.dungeon.events.fight;

import java.util.ArrayList;

import rpg.core.dungeon.DungeonType;
import rpg.core.spawn.PartySpawnPatternEnumeration;

public class SpecialFight extends Fight {

	public SpecialFight() {
		super();
	}
	
	public SpecialFight(DungeonType restriction) {
		super(restriction);
	}

	@Override
	public void initEvent() {
		avaliableEnumerations = new ArrayList<PartySpawnPatternEnumeration>() {
			{
				add(null);
			}
		};

	}

}
