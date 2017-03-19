package com.disgrace.ddripoff.spawn;

import java.util.Random;

public enum SpawnableEventType {
	FIGHT(20) {
		@Override
		public SpawnEvent getEvent() {
			return new Fight();
		}
	},
	TREASURE(30) {
		@Override
		public SpawnEvent getEvent() {
			return new Treasure();
		}
	};

	private int spawnRate;

	private SpawnableEventType(int spawnRate) {
		this.spawnRate = spawnRate;
	}

	public static SpawnableEventType getRandomValue() {
		return values()[new Random().nextInt(values().length)];
	}
	
	public static SpawnEvent spawnEventByChance(int chance){
		if(chance<FIGHT.spawnRate){
			return FIGHT.getEvent();
		}else if(chance>=FIGHT.spawnRate&&chance<TREASURE.spawnRate){
			return TREASURE.getEvent();
		}else{
			return null;
		}
	}
	
	public abstract SpawnEvent getEvent();
}
