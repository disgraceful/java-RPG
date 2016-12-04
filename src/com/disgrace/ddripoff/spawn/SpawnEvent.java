package com.disgrace.ddripoff.spawn;

public abstract class SpawnEvent {
	protected SpawnableEventType spawnType;
	protected int SPAWN_CHANCE;
	
	public SpawnableEventType getSpawnType() {
		return spawnType;
	}
	
	public abstract void trigger();
}
