package com.disgrace.ddripoff.dungeon;

import java.util.Random;
import java.util.Set;

import com.disgrace.ddripoff.spawn.SpawnEvent;
import com.disgrace.ddripoff.spawn.SpawnableEventType;

public class DungeonEventSpawner {
	private Set<Enterable> possibleSpawnLocations;

	public DungeonEventSpawner(Set<Enterable> enterables) {
		possibleSpawnLocations =enterables;
	}

	public void generateSpawns() {
		for (Enterable e : possibleSpawnLocations) {
			SpawnEvent se = SpawnableEventType.spawnEventByChance(new Random().nextInt(101));
			if(se!=null){
				e.addEvent(se);
			}
		}
	}
}
