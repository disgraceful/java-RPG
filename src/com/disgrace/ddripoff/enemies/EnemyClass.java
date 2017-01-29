package com.disgrace.ddripoff.enemies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.disgrace.ddripoff.characters.shared.CharacterClass;
import com.disgrace.ddripoff.spawn.EnemySpawnType;

public enum EnemyClass  implements CharacterClass {
	OUTCAST_CROSSBOWMAN("Outcast Crossbowman", new ArrayList<EnemySubType>() {
		{
			add(EnemySubType.HUMAN);
		}
	}, EnemySpawnType.BACK) {
		@Override
		public Enemy getCharacterToSpawn() {
			return new OutcastCrossbowman();
		}
	},

	OUTCAST_SWORDSMAN("Outcast Swordsman", new ArrayList<EnemySubType>() {
		{
			add(EnemySubType.HUMAN);
		}
	}, EnemySpawnType.MIDDLE) {
		@Override
		public Enemy getCharacterToSpawn() {
			return new OutcastSwordsman();
		}
	},
	OUTCAST_KNIGHT("Outcast Knight", new ArrayList<EnemySubType>() {
		{
			add(EnemySubType.HUMAN);
		}
	}, EnemySpawnType.FRONT) {
		@Override
		public Enemy getCharacterToSpawn() {
			return new OutcastKnight();
		}
	};

	private List<EnemySubType> eSubType;
	private EnemySpawnType eSpawnType;

	private EnemyClass(String name, List<EnemySubType> subTypes, EnemySpawnType spawnType) {
		eSubType = subTypes;
		eSpawnType = spawnType;
	}

	private String name;
	private static final Random RANDOM = new Random();
	private static final List<EnemyClass> VALUES = new ArrayList<EnemyClass>() {
		{
			add(EnemyClass.OUTCAST_CROSSBOWMAN);
			add(EnemyClass.OUTCAST_SWORDSMAN);
			add(EnemyClass.OUTCAST_KNIGHT);
		}
	};
	private static final int SIZE = VALUES.size();

	public static EnemyClass getRandomValue() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}

	@Override
	public String toString() {
		return name;
	}
	
	public static List<EnemyClass> getClassBySpawnType(EnemySpawnType spawnType){
		List<EnemyClass>classesBySpawnType = new ArrayList<>();
		for(EnemyClass eClass : VALUES){
			if(eClass.eSpawnType ==spawnType){
				classesBySpawnType.add(eClass);
			}
		}
		return classesBySpawnType;
	}
	
	public List<EnemySubType> getEnemySubType() {
		return eSubType;
	}

	public EnemySpawnType getEnemySpawnType() {
		return eSpawnType;
	}

	
}
