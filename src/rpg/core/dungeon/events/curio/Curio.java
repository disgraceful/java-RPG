package rpg.core.dungeon.events.curio;

import java.util.List;

import rpg.core.dungeon.DungeonType;
import rpg.core.dungeon.events.SpawnEvent;
import rpg.core.dungeon.events.SpawnableEventType;

public class Curio extends SpawnEvent {

	protected List<DungeonType> areaRestriction;

	public Curio() {
		spawnType = SpawnableEventType.CURIO;

	}

	@Override
	public void trigger() {

	}

	@Override
	public void spawn() {
		// TODO Auto-generated method stub

	}

}
