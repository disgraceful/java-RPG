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

	public void generateSpawns() {
		for (Enterable e : possibleSpawnLocations) {
			//e.display();
			int chance = new Random().nextInt(101);
			SpawnEvent se = SpawnableEventType.spawnEventByChance(chance);
//			System.out.println("Chance: " + chance);
//			if(se!=null){
//			System.out.println("spawned event " + se.toString());
//			}else{
//				System.out.println("empty room");
//			}
			e.addEvent(se);
		}
	}
}
