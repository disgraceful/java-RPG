package rpg.core.dungeon.events.fight;

import java.util.ArrayList;

import rpg.core.dungeon.DungeonType;
import rpg.core.items.LootType;
import rpg.core.spawn.PartySpawnPatternEnumeration;

public class ToughFight extends Fight {

	public ToughFight() {
		super();
	}

	public ToughFight(DungeonType restriction) {
		super(restriction);
	}

	@Override
	public void initEvent() {
		avaliableEnumerations = new ArrayList<PartySpawnPatternEnumeration>() {
			{
				add(PartySpawnPatternEnumeration.STRONG_BACK);
				add(PartySpawnPatternEnumeration.STRONG_DEFAULT);
				add(PartySpawnPatternEnumeration.STRONG_FRONT);
				add(PartySpawnPatternEnumeration.STRONG_FULL_GLASS);
				add(PartySpawnPatternEnumeration.STRONG_FULL_MIDDLE);
				add(PartySpawnPatternEnumeration.STRONG_MIDDLE);
			}
		};
		lootType = LootType.LARGE_LOOT;

	}

}
