package rpg.core.spawn.events;

import java.util.ArrayList;
import java.util.List;

import rpg.core.factories.CharacterFactory;
import rpg.core.items.LootType;
import rpg.core.spawn.PartySpawnPatternEnumeration;

public class MidFight extends Fight{
	
	public MidFight() {
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

