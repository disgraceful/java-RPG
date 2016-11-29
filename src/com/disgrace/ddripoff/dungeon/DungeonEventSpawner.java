package com.disgrace.ddripoff.dungeon;

import java.util.Random;
import java.util.Set;

import com.disgrace.ddripoff.spawn.SpawnableEventType;

public class DungeonEventSpawner {

	private Dungeon currentDungeon;
	private Set<Enterable> possibleSpawnLocations;

	private final int EVENT_MAX = 25;
	private final int ODDS_MAX = 100;
	private final Random RAND = new Random();

	public DungeonEventSpawner(Dungeon dungeon) {
		this.currentDungeon = dungeon;
		possibleSpawnLocations = dungeon.getAllEnterables();
	}

	public void generateSpawns() {
		int chance = RAND.nextInt(ODDS_MAX + 1);
		for (Enterable e : possibleSpawnLocations) {
			if (chance > EVENT_MAX) {
				e.addEvent(SpawnableEventType.getRandomValue().getEvent());
			}
		}
	}
}
