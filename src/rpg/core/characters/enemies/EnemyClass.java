package rpg.core.characters.enemies;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import rpg.core.characters.shared.CharClass;
import rpg.core.spawn.EnemySpawnType;
import rpg.core.utils.CalcHelper;
import rpg.core.utils.StreamUtils;

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
	private static List<EnemyClass>values = Arrays.asList(values());
			

	private EnemyClass(EnemySpawnType spawnType) {

		eSpawnType = spawnType;
	}

	public EnemySpawnType getEnemySpawnType() {
		return eSpawnType;
	}

	public static EnemyClass getRandomValue() {
		return values.get(CalcHelper.randInt(values.size()));
	}

	public static List<EnemyClass> getAllBySpawnType(EnemySpawnType spawnType) {
		return values.stream().filter(e -> e.getEnemySpawnType() == spawnType).collect(Collectors.toList());
	}

	public static Class<?> getRandomEnemyBySpawnType(EnemySpawnType spawnType) {
		return StreamUtils.getRandomItemFromStream(values.stream().filter(e -> e.eSpawnType == spawnType)).getClassToSpawn();
	}
	
	public static Class<?> getRandomEnemy(EnemySpawnType spawnType,DungeonType) {
		return StreamUtils.getRandomItemFromStream(values.stream().filter(e -> e.eSpawnType == spawnType)).getClassToSpawn();
	}

}
