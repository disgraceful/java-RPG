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
	};
	

	public static SpawnableEventType getRandomValue() {
		return values()[(new Random().nextInt(values().length))];
	}

	public abstract SpawnEvent getEvent();
}
