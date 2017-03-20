package com.disgrace.ddripoff.dungeon;

import java.util.List;
import java.util.Random;

import com.disgrace.ddripoff.spawn.SpawnEvent;
import com.disgrace.ddripoff.spawn.SpawnableEventType;

public class DungeonEventSpawner {
	private List<Enterable> possibleSpawnLocations;

	public DungeonEventSpawner(List<Enterable> enterables) {
		possibleSpawnLocations = enterables;
	}

	public void generateSpawns(int maxFightAmount) {
		List<Enterable> list = possibleSpawnLocations.subList(0, possibleSpawnLocations.size() - 1);
		int currentFightAmount = 0;
		while (currentFightAmount < maxFightAmount) {
			Enterable e = list.get(new Random().nextInt(list.size()));
			SpawnEvent se = SpawnableEventType.spawnEventByChance(new Random().nextInt(101));
			if (se != null && se.getSpawnType() == SpawnableEventType.FIGHT) {
				currentFightAmount++;
				e.addEvent(se);
			} else {
				e.addEvent(se);
			}
		}
	}
}
