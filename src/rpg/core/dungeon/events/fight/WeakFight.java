package rpg.core.dungeon.events.fight;

import java.util.ArrayList;
import java.util.List;

import rpg.core.factories.CharacterFactory;
import rpg.core.items.LootType;
import rpg.core.spawn.PartySpawnPatternEnumeration;

public class WeakFight extends Fight {
	public WeakFight() {
		avaliableEnumerations = new ArrayList<PartySpawnPatternEnumeration>() {
			{
				add(PartySpawnPatternEnumeration.WEAK_BALANCED);
				add(PartySpawnPatternEnumeration.WEAK_FRONT_ONLY);
			}
		};
		lootType = LootType.SMALL_LOOT;
	}

}
