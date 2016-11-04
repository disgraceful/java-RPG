package com.disgrace.ddripoff.dungeon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Dungeon {
	// protected DungeonType type;
	// public Room startingRoom;
	private Room[][] rooms;
	protected DungeonSize size;

	public Dungeon(DungeonSize size) {
		rooms = new Room[size.ybound][size.xbound];
		this.size = size;
		
		// startingRoom = rooms.get(new Random().nextInt(rooms.size()));
		// startingRoom.visited = true;
	}

	public List<Room> getRoomsAsList() {
		List<Room> elements = new ArrayList<Room>();
		for (Room[] array : rooms) {
			elements.addAll(Arrays.asList(array));
		}
		return elements;
	}
	
	public Room[][]getRooms(){
		return rooms;
	}

	public void displayRooms() {
		for (int i = 0; i < size.ybound; i++) {
			for (int j = 0; j < size.xbound; j++) {
				rooms[i][j].display();
				rooms[i][j].displayNeighbours();
				rooms[i][j].displayCorridors();
				System.out.println("");
			}
		}
	}
	
	public void displayRoomsValue() {
		for (int i = 0; i < size.ybound; i++) {
			for (int j = 0; j < size.xbound; j++) {
				System.out.print(rooms[i][j].getAdds().value + " ");				
			}
			System.out.println("");
		}
	}
}
