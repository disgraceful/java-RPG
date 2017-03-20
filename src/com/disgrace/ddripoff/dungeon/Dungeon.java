package com.disgrace.ddripoff.dungeon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public abstract class Dungeon {
	protected DungeonType dungType;
	protected DungeonSize size;
	protected Room startRoom;
	protected Room[][] rooms;
	protected boolean isCompleted;
	
	public Dungeon(DungeonSize size) {
		this.size = size;
		setRooms(size.xbound, size.ybound);
	}
	
	public boolean isCompleted(){
		return isCompleted;
	}
	public void setIsCompleted(boolean isCompleted){
		this.isCompleted = isCompleted;
	}

	public Room[][] getRooms() {
		return rooms;
	}

	public Room getStartRoom() {
		return startRoom;
	}

	public void setStartingRoom() {
		startRoom = getOnlyEnterableRooms().get(new Random().nextInt(getOnlyEnterableRooms().size()));
	}

	private void setRooms(int xbound, int ybound) {
		rooms = new Room[size.ybound][size.xbound];
		for (int i = 0; i < ybound; i++) {
			for (int j = 0; j < xbound; j++) {
				rooms[i][j] = new Room();
				rooms[i][j].getAdds().x = j;
				rooms[i][j].getAdds().y = i;
			}
		}
	}

	public List<Room> getAllRoomsAsList() {
		List<Room> elements = new ArrayList<>();
		for (Room[] array : rooms) {
			elements.addAll(Arrays.asList(array));
		}
		return elements;
	}

	public List<Room> getEnterableRoomsExcludingStarting() {
		List<Room> elements = new ArrayList<>();
		for (Iterator<Room> iterator = getAllRoomsAsList().iterator(); iterator.hasNext();) {
			Room room = (Room) iterator.next();
			if (!room.equals(startRoom)) {
				elements.add(room);
			}
		}
		return elements;
	}

	public List<Room> getOnlyEnterableRooms() {
		List<Room> elements = new ArrayList<>();
		for (Iterator<Room> iterator = getAllRoomsAsList().iterator(); iterator.hasNext();) {
			Room room = (Room) iterator.next();
			if (room.getAdds().value != 1) {
				elements.add(room);
			}
		}
		return elements;
	}

	public List<Enterable> getAllEnterables() {
		List<Enterable> enterables = new ArrayList<>();
		for (Room r : getEnterableRoomsExcludingStarting()) {
			enterables.add(r);
			for (Corridor cor : r.getCorridors()) {
				for (CorridorSection cs : cor.getSections()) {
					if (!enterables.contains(cs)) {
						enterables.add(cs);
					}
				}
			}
		}
		return enterables;
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
				System.out.print(i + " x " + j + " value: " + rooms[i][j].getAdds().value + " ");
				System.out.println(rooms[i][j].getEvents());
			}
			System.out.println("");
		}
	}

	public void displayEnterablesValue() {
		for (Room e : getOnlyEnterableRooms()) {
			e.display();
			System.out.println(e.getEvents());
			for (Corridor c : e.getCorridors()) {
				c.display();
				for (CorridorSection cs : c.getSections()) {
					System.out.println(cs.getEvents());
				}
			}
		}
	}

}
