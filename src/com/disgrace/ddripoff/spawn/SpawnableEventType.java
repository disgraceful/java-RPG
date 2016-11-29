package com.disgrace.ddripoff.spawn;

import java.util.ArrayList;
import java.util.Random;

public enum SpawnableEventType {
	FIGHT {
		public SpawnEvent getEvent() {
			return new Fight();
		}
	},
	TREASURE {
		public SpawnEvent getEvent() {
			return new Treasure();
		}
	},
	CURIO {
		public SpawnEvent getEvent() {
			return new Curio();
		}
	},
	MEMEORY {
		public SpawnEvent getEvent() {
			return new Memory();
		}
	};
	
	private static final Random RANDOM = new Random();
	private static final ArrayList<SpawnableEventType> VALUES = new ArrayList<SpawnableEventType>() {
		{
			add(SpawnableEventType.FIGHT);
			add(SpawnableEventType.TREASURE);
			add(SpawnableEventType.CURIO);
			add(SpawnableEventType.MEMEORY);
		}
	};
	private static final int SIZE = VALUES.size();

	public static SpawnableEventType getRandomValue() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}

	public abstract SpawnEvent getEvent();
}
