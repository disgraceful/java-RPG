package rpg.core.spawn.events;

import java.util.ArrayList;
import java.util.List;

import rpg.core.spawn.CharacterFactory;
import rpg.core.spawn.PartySpawnPatternEnumeration;

public class WeakFight extends Fight {
	public WeakFight() {
		avaliableEnumerations = new ArrayList<PartySpawnPatternEnumeration>() {
			{
				add(PartySpawnPatternEnumeration.WEAK_BALANCED);
				add(PartySpawnPatternEnumeration.WEAK_FRONT_ONLY);
			}
		};

	}

}
