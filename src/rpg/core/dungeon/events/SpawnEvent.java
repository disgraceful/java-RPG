package rpg.core.dungeon.events;

import java.util.List;

import rpg.core.dungeon.DungeonType;
import rpg.core.dungeon.events.curio.CurioType;
import rpg.core.items.Loot;
import rpg.core.items.LootType;

public abstract class SpawnEvent {
	protected SpawnableEventType spawnType;
	protected boolean triggered;
	protected Loot loot;
	protected LootType lootType;
	protected List<DungeonType> areaRestriction;

	public SpawnableEventType getSpawnType() {
		return spawnType;
	}

	public boolean isTriggered() {
		return triggered;
	}

	public void setTriggered(boolean triggered) {
		this.triggered = triggered;
	}

	public List<DungeonType> getAreaRestriction() {
		return areaRestriction;
	}

	public abstract void trigger();
	public abstract void spawn();

}
