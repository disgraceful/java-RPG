package com.disgrace.ddripoff.dungeon;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.disgrace.ddripoff.spawn.SpawnEvent;
import com.disgrace.ddripoff.spawn.SpawnableEventType;

public class DungeonEventSpawner {
	private Set<Enterable> possibleSpawnLocations;

	private final int ODDS_FIRST_EVENT = 30;
	private final int ODDS_SECOND_EVENT = 60;
	private final int ODDS_MAX = 100;
	private final Random RAND = new Random();

	public DungeonEventSpawner(List<Enterable> enterables) {
		possibleSpawnLocations = new HashSet<>(enterables);
	}

	public void generateSpawns() {
		int chance = RAND.nextInt(ODDS_MAX + 1);
		for (Enterable e : possibleSpawnLocations) {
			if (chance >ODDS_MAX - ODDS_FIRST_EVENT) {
				e.addEvent(SpawnableEventType.getRandomValue().getEvent());
				for(SpawnEvent event: e.getEvents()){
					if(event.getSpawnType()!=SpawnableEventType.FIGHT&&chance>ODDS_MAX -ODDS_SECOND_EVENT ){
						e.addEvent(SpawnableEventType.FIGHT.getEvent());
					}
				}
			}
		}
	}
}
