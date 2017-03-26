package com.disgrace.ddripoff.characters.enemies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.disgrace.ddripoff.characters.shared.SpawnableChar;
import com.disgrace.ddripoff.spawn.EnemySpawnType;

public enum EnemyClass implements SpawnableChar {
	OUTCAST_CROSSBOWMAN(EnemySpawnType.BACK) {

		@Override
		public Enemy getCharacterToSpawn() {
			return new OutcastCrossbowman();
		}
	},

	OUTCAST_SWORDSMAN(EnemySpawnType.MIDDLE) {

		@Override
		public Enemy getCharacterToSpawn() {
			return new OutcastSwordsman();
		}
	},
	OUTCAST_KNIGHT(EnemySpawnType.FRONT) {

		@Override
		public Enemy getCharacterToSpawn() {
			return new OutcastKnight();
		}
	},

	TESTING_DUMMY(EnemySpawnType.FRONT) {
		@Override
		public Enemy getCharacterToSpawn() {
			return new TestingDummy();
		}
	};

	// private List<EnemySubType> eSubType;
	private EnemySpawnType eSpawnType;

	private EnemyClass(EnemySpawnType spawnType) {

		eSpawnType = spawnType;
	}
	
	// private EnemyClass(List<EnemySubType> subTypes, EnemySpawnType spawnType)
	// {
	// eSubType = subTypes;
	// eSpawnType = spawnType;
	// }

	// public List<EnemySubType> getEnemySubType() {
	// return eSubType;
	// }

	public EnemySpawnType getEnemySpawnType() {
		return eSpawnType;
	}

	public static EnemyClass getRandomValue() {
		return values()[new Random().nextInt(values().length)];
	}

	public static List<EnemyClass> getAllBySpawnType(EnemySpawnType spawnType) {
		List<EnemyClass> classesBySpawnType = new ArrayList<>();
		for (EnemyClass eClass : Arrays.asList(values())) {
			if (eClass.eSpawnType == spawnType) {
				classesBySpawnType.add(eClass);
			}
		}
		return classesBySpawnType;
	}

	public static Enemy getRandomEnemyBySpawnType(EnemySpawnType spawnType) {
		List<EnemyClass> list = Arrays.asList(values());
		Collections.shuffle(list);
		return (Enemy) list.stream().filter(e -> e.eSpawnType == spawnType).findAny().get().getCharacterToSpawn();

	}

}
