package com.disgrace.ddripoff.dungeon;

import java.util.Random;
import java.util.Set;

import com.disgrace.ddripoff.spawn.Fight;

public class DungeonObjectSpawner {

	private Dungeon currentDungeon;
	private Set<Enterable> possibleSpawnLocations;

	private final int FIGHT_MAX = 20;
	private final int ODDS_MAX = 100;
	private final Random RAND = new Random();

	public DungeonObjectSpawner(Dungeon dungeon) {
		this.currentDungeon = dungeon;
		possibleSpawnLocations = dungeon.getAllEnterables();
	}

	public void generateSpawns() {
		int chance = RAND.nextInt(ODDS_MAX + 1);
		for (Enterable e : possibleSpawnLocations) {
			if (chance > FIGHT_MAX) {
				e.addEvent(new Fight());
			}
		}
	}
}
