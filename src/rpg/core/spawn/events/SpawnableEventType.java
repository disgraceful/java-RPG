package rpg.core.spawn.events;

import java.util.Random;

public enum SpawnableEventType {
	FIGHT(35) {
		@Override
		public SpawnEvent getEvent() {
			return new Fight();
		}
	},
	TREASURE(40) {
		@Override
		public SpawnEvent getEvent() {
			return new Treasure();
		}
	},
	CURIO(45) {
		@Override
		public SpawnEvent getEvent() {
			return new Curio();
		}
	};

	private int chance;

	private SpawnableEventType(int chance) {
		this.chance = chance;
	}

	public int getChance() {
		return chance;
	}

	public static SpawnableEventType getRandomValue() {
		return values()[new Random().nextInt(values().length)];
	}

	public abstract SpawnEvent getEvent();
}