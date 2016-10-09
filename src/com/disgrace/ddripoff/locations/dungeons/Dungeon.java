package com.disgrace.ddripoff.locations.dungeons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import com.disgrace.ddripoff.locations.dungeons.components.Room;
import com.disgrace.ddripoff.locations.dungeons.components.RoomSide;

public abstract class Dungeon {
	public ArrayList<Room> rooms = new ArrayList<Room>();
	protected DungeonType type;
	public Room startingRoom;

	public Dungeon(int capacity) {
		for (int i = 0; i < capacity; i++) {
			rooms.add(new Room());
		}

		startingRoom = rooms.get(new Random().nextInt(rooms.size()));
		startingRoom.visited = true;
		buildLevel();
	}

	private void buildLevel() {
		ArrayList<Room> setRooms = new ArrayList<Room>();
		Iterator<Room> iter = rooms.iterator();
		while (iter.hasNext()) {
			Room r = iter.next();
			if (setRooms.size() <= 0) {
				setRooms.add(r);
				continue;
			} else {
				int randIndex = new Random().nextInt(setRooms.size());
				r.setNeigbour(setRooms.get(randIndex), RoomSide.getRandomValue());
				setRooms.add(r);
			}
		}
	}

	public void displayRooms() {
		for (Room r : rooms) {
			System.out.println(r.toString());
		}
		System.out.println("");
	}
}
