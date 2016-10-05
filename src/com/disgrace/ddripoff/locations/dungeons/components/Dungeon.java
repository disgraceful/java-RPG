package com.disgrace.ddripoff.locations.dungeons.components;

import java.util.ArrayList;
import java.util.Random;

import com.disgrace.ddripoff.locations.dungeons.DungeonType;

public abstract class Dungeon {
	public ArrayList<Room> rooms = new ArrayList<Room>();
	protected DungeonType type;
	public Room startingRoom;

	public Dungeon(int capacity) {
		for (int i = 0; i < capacity; i++) {
			rooms.add(new Room());
		}
		startingRoom = rooms.get(new Random().nextInt(rooms.size()));

	}

}
