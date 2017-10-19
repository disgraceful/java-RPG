package rpg.core.spawn.events;

public abstract class SpawnEvent {
	protected SpawnableEventType spawnType;
	protected boolean triggered;

	public SpawnableEventType getSpawnType() {
		return spawnType;
	}

	public boolean isTriggered() {
		return triggered;
	}

	public void setTriggered(boolean triggered) {
		this.triggered = triggered;
	}

	public abstract void trigger();
}
