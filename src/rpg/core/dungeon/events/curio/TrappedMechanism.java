package rpg.core.dungeon.events.curio;

import java.util.ArrayList;

import rpg.core.dungeon.DungeonType;

public class TrappedMechanism extends Curio {
	public TrappedMechanism() {
		areaRestriction = new ArrayList<DungeonType>() {
			{
				add(DungeonType.RUINS);
			}
		};
	}
}
