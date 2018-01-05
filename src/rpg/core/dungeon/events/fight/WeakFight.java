package rpg.core.dungeon.events.fight;

import java.util.ArrayList;

import rpg.core.dungeon.DungeonType;
import rpg.core.items.LootType;
import rpg.core.spawn.PartySpawnPatternEnumeration;

public class WeakFight extends Fight {
	public WeakFight() {
		super();
		spawn();
	}

	public WeakFight(DungeonType restriction) {
		super(restriction);
	}

	@Override
	public void initEvent() {
		avaliableEnumerations = new ArrayList<PartySpawnPatternEnumeration>() {
			{
				add(PartySpawnPatternEnumeration.WEAK_BALANCED);
				add(PartySpawnPatternEnumeration.WEAK_FRONT_ONLY);
			}
		};
		lootType = LootType.SMALL_LOOT;

	}
}
