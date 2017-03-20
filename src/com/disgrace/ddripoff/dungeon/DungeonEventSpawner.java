package com.disgrace.ddripoff.dungeon;

import java.util.List;
import java.util.Random;

import com.disgrace.ddripoff.spawn.SpawnEvent;
import com.disgrace.ddripoff.spawn.SpawnableEventType;

public class DungeonEventSpawner {
	private List<Enterable> possibleSpawnLocations;
	private int fightAmount;

	public DungeonEventSpawner(Dungeon dung) {
		possibleSpawnLocations = dung.getAllEnterables();
		fightAmount = dung.size.fightAmount;
	}

	public void generate() {
		generateSpawns(fightAmount);

	}

	public void generateSpawns(int maxFightAmount) {
		List<Enterable> list = possibleSpawnLocations.subList(0, possibleSpawnLocations.size() - 1);
		int currentFightAmount = countEventAmountByType(SpawnableEventType.FIGHT);
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

	public void generateConcreteEvent(Enterable location, SpawnEvent event) {
		location.addEvent(event);
		return;
	}

	private int countEventAmountByType(SpawnableEventType type) {
		return (int) possibleSpawnLocations.stream().filter(e -> e.containsSpawnType(type)).count();
	}
}
