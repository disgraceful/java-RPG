package rpg.core.characters.enemies;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import rpg.core.characters.shared.CharClass;
import rpg.core.dungeon.DungeonType;
import rpg.core.spawn.EnemySpawnType;
import rpg.core.utils.CalcHelper;
import rpg.core.utils.StreamUtils;

public enum EnemyClass implements CharClass {
	OUTCAST_CROSSBOWMAN(EnemySpawnType.BACK) {
		@Override
		public Class<OutcastCrossbowman> getClassToSpawn() {
			return OutcastCrossbowman.class;
		}

		@Override
		public Enemy getEnemyToSpawn() {
			return new OutcastCrossbowman();
		}
	},

	OUTCAST_SWORDSMAN(EnemySpawnType.MIDDLE) {
		@Override
		public Class<OutcastSwordsman> getClassToSpawn() {
			return OutcastSwordsman.class;
		}

		@Override
		public Enemy getEnemyToSpawn() {
			return new OutcastSwordsman();
		}
	},

	OUTCAST_KNIGHT(EnemySpawnType.FRONT) {
		@Override
		public Class<OutcastKnight> getClassToSpawn() {
			return OutcastKnight.class;
		}

		@Override
		public Enemy getEnemyToSpawn() {
			return new OutcastKnight();
		}
	},

	TESTING_DUMMY(EnemySpawnType.FRONT) {
		@Override
		public Class<TestingDummy> getClassToSpawn() {
			return TestingDummy.class;
		}

		@Override
		public Enemy getEnemyToSpawn() {
			return new TestingDummy();
		}
	};

	private EnemySpawnType eSpawnType;
	private static List<EnemyClass> values = Arrays.asList(values());

	private EnemyClass(EnemySpawnType spawnType) {
		eSpawnType = spawnType;
	}

	public abstract Enemy getEnemyToSpawn();

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
		return StreamUtils.getRandomItemFromStream(values.stream().filter(e -> e.eSpawnType == spawnType))
				.getClassToSpawn();
	}

	public static Class<?> getRandomEnemy(EnemySpawnType spawnType, DungeonType restriction) {
		return StreamUtils.getRandomItemFromStream(values.stream().filter(
				e -> e.getEnemyToSpawn().isAreaGeneric() || e.getEnemyToSpawn().getAreaRestriction() == restriction))
				.getClassToSpawn();
	}

}
