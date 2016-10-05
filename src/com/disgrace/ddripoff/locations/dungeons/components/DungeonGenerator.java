package com.disgrace.ddripoff.locations.dungeons.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class DungeonGenerator {

	private static Random rand = new Random();

	public static void buildLevel(Dungeon dungeon) {
		ArrayList<Room> setRooms = new ArrayList<Room>();
		Iterator<Room> iter = dungeon.rooms.iterator();
		while (iter.hasNext()) {
			Room r = iter.next();
			if (setRooms.size() <= 0) {
				setRooms.add(r);
				iter.remove();
				continue;
			} else {
				int randIndex = rand.nextInt(setRooms.size());
				r.setNeigbour(setRooms.get(randIndex), RoomSide.getRandomValue());
				setRooms.add(r);
			}
		}
	}
}
