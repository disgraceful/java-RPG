package rpg.core.dungeon.events.curio;

import rpg.core.dungeon.DungeonType;

public class HolyAltar extends Curio {
	public HolyAltar() {
		areaRestriction = DungeonType.RUINS;
	}
}
