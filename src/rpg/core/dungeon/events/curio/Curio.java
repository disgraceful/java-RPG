package rpg.core.dungeon.events.curio;

import rpg.core.dungeon.events.SpawnEvent;
import rpg.core.dungeon.events.SpawnableEventType;
import rpg.core.items.Item;

public class Curio extends SpawnEvent {

	protected Item unlocker;
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
