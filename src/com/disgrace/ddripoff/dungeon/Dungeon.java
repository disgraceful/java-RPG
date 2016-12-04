package com.disgrace.ddripoff.dungeon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public abstract class Dungeon {
	protected DungeonType DUNG_TYPE;
	protected final Room START_ROOM = getStartingRoom();
	private Room[][] rooms;
	protected DungeonSize size;

	public Dungeon(DungeonSize size) {
		rooms = new Room[size.ybound][size.xbound];
		this.size = size;
	}

	public List<Room> getRoomsAsList() {
		List<Room> elements = new ArrayList<Room>();
		for (Room[] array : rooms) {
			elements.addAll(Arrays.asList(array));
		}
		return elements;
	}
	
	public List<Room>getEnterableRoomsAsList(){
		List<Room> elements = new ArrayList<Room>();
		for (Room[] array : rooms) {
			elements.addAll(Arrays.asList(array));
		}
		for(Room r:elements){
			if (r.getAdds().value == 1) {
				continue;
			}
			elements.add(r);
		}
		return elements;
	}

	public Room getSTART_ROOM() {
		return START_ROOM;
	}

	public Set<Enterable> getAllEnterables() {
		Set<Enterable> enterables = new HashSet<Enterable>();
		for (Room r : getRoomsAsList()) {
			if (r.getAdds().value == 1||r==START_ROOM) {
				continue;
			}
			enterables.add(r);
			for (Corridor cor : r.getCorridors()) {
				for (CorridorSection cs : cor.getSections()) {
					enterables.add(cs);
				}
			}
		}
		return enterables;
	}

	public Room[][] getRooms() {
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
	
	private Room getStartingRoom(){
		return getEnterableRoomsAsList().get(new Random().nextInt(getEnterableRoomsAsList().size()+1));
	}
}
