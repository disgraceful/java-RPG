package rpg.core.spawn.events;

import java.util.ArrayList;
import java.util.List;

import rpg.core.spawn.CharacterFactory;
import rpg.core.spawn.PartySpawnPatternEnumeration;

public class ToughFight extends Fight {

	List<PartySpawnPatternEnumeration> avaliableEnumerations = new ArrayList<PartySpawnPatternEnumeration>() {
		{
			add(PartySpawnPatternEnumeration.STRONG_BACK);
			add(PartySpawnPatternEnumeration.STRONG_DEFAULT);
			add(PartySpawnPatternEnumeration.STRONG_FRONT);
			add(PartySpawnPatternEnumeration.STRONG_FULL_GLASS);
			add(PartySpawnPatternEnumeration.STRONG_FULL_MIDDLE);
			add(PartySpawnPatternEnumeration.STRONG_MIDDLE);
		}
	};

	

}
