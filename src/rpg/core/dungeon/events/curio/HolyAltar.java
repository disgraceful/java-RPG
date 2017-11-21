package rpg.core.dungeon.events.curio;

import java.util.ArrayList;

import rpg.core.dungeon.DungeonType;

public class HolyAltar extends Curio {
	public HolyAltar() {
		areaRestriction = new ArrayList<DungeonType>() {
			{
				add(DungeonType.RUINS);
			}
		};
	}
}
