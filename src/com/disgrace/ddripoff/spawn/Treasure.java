package com.disgrace.ddripoff.spawn;

public class Treasure extends SpawnEvent {

	public Treasure() {
		spawnType = SpawnableEventType.TREASURE;
		SPAWN_CHANCE = 30;	
	}
	@Override
	public void trigger() {
		
	}

}
