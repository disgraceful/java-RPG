package rpg.core.dungeon.events.fight;

import java.util.ArrayList;

import rpg.core.dungeon.DungeonType;
import rpg.core.items.LootType;
import rpg.core.spawn.PartySpawnPatternEnumeration;

public class MidFight extends Fight{
	
	public MidFight() {
		super();
		spawn();
	}
	
	public MidFight(DungeonType restriction) {
		super(restriction);
	}
	
	@Override
	public void initEvent() {
		avaliableEnumerations = new ArrayList<PartySpawnPatternEnumeration>() {
			{
				add(PartySpawnPatternEnumeration.MID_BALANCED);
				add(PartySpawnPatternEnumeration.MID_MIDDLE);
				add(PartySpawnPatternEnumeration.MID_MIDDLE_ONLY);
				add(PartySpawnPatternEnumeration.MID_MIDDLE_ONLY);
			}
		};
		lootType = LootType.MEDIUM_LOOT;
		
	}

}

