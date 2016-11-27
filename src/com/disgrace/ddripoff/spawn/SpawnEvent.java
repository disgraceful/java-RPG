package com.disgrace.ddripoff.spawn;

public abstract class SpawnEvent {
	protected SpawnableEventType spawnType;
	
	public SpawnableEventType getSpawnType() {
		return spawnType;
	}

	public abstract void trigger();
}
