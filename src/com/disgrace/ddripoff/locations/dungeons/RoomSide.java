package com.disgrace.ddripoff.locations.dungeons;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum RoomSide {
	SOUTH, NORTH, WEST, EAST;

	private final static Random RANDOM = new Random();
	private static final List<RoomSide> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();

	public static RoomSide getRandomValue() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
