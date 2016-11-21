package com.disgrace.ddripoff.dungeon;

import java.util.Set;

public class DungeonObjectSpawner {

	private Dungeon currentDungeon;
	private Set<Enterable>possibleSpawnLocations;
	//private List<Enterable>
	public DungeonObjectSpawner(Dungeon dungeon) {
		this.currentDungeon= dungeon;
		possibleSpawnLocations = dungeon.getAllEnterables();
	}
	
	public void generateSpawns(){
		
	}
}
