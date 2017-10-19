package rpg.core.characters.enemies;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import rpg.core.characters.shared.CharClass;
import rpg.core.spawn.EnemySpawnType;

public enum EnemyClass implements CharClass {
	OUTCAST_CROSSBOWMAN(EnemySpawnType.BACK) {
		@Override
		public Class<OutcastCrossbowman> getClassToSpawn() {
			return OutcastCrossbowman.class;
		}
	},

	OUTCAST_SWORDSMAN(EnemySpawnType.MIDDLE) {
		@Override
		public Class<OutcastSwordsman> getClassToSpawn() {
			return OutcastSwordsman.class;
		}
	},
	OUTCAST_KNIGHT(EnemySpawnType.FRONT) {
		@Override
		public Class<OutcastKnight> getClassToSpawn() {
			return OutcastKnight.class;
		}
	},

	TESTING_DUMMY(EnemySpawnType.FRONT) {
		@Override
		public Class<TestingDummy> getClassToSpawn() {
			return TestingDummy.class;
		}
	};

	private EnemySpawnType eSpawnType;

	private EnemyClass(EnemySpawnType spawnType) {

		eSpawnType = spawnType;
	}

	public EnemySpawnType getEnemySpawnType() {
		return eSpawnType;
	}

	public static EnemyClass getRandomValue() {
		return values()[new Random().nextInt(values().length)];
	}

	public static List<EnemyClass> getAllBySpawnType(EnemySpawnType spawnType) {
		return Arrays.stream(values()).filter(e -> e.getEnemySpawnType() == spawnType).collect(Collectors.toList());
	}

	public static Class<?> getRandomEnemyBySpawnType(EnemySpawnType spawnType) {
		Collections.shuffle(Arrays.asList(values()));
		return Arrays.stream(values()).filter(e -> e.eSpawnType == spawnType).findFirst().get().getClassToSpawn();

	}

}
