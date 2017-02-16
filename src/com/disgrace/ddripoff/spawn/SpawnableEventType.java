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
	public static SpawnableEventType getRandomValue() {
		return values()[(RANDOM.nextInt(values().length))];
	}

	public abstract SpawnEvent getEvent();
}
