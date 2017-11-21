package rpg.core.dungeon.events.curio;

import java.util.ArrayList;

import rpg.core.dungeon.DungeonType;

public class CorruptedFountain extends Curio {

	public CorruptedFountain() {
		areaRestriction = new ArrayList<DungeonType>() {
			{
				add(DungeonType.RUINS);
				add(DungeonType.RAIN_FOREST);
			}
		};
	}
}
