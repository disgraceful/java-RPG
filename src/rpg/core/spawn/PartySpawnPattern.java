package rpg.core.spawn;

import java.util.ArrayList;
import java.util.List;

public class PartySpawnPattern {
	private List<EnemySpawnType> spawnTypes = new ArrayList<>();

	public PartySpawnPattern(List<EnemySpawnType> spawns) {
		spawnTypes = spawns;

	}

	public List<EnemySpawnType> getSpawnTypes() {
		return spawnTypes;
	}

	public void setSpawnTypes(List<EnemySpawnType> spawnTypes) {
		if (spawnTypes == null) {
			return;
		}
		this.spawnTypes = spawnTypes;
	}

}