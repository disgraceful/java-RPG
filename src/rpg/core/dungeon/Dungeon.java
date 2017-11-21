package rpg.core.dungeon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import rpg.core.dungeon.events.SpawnEvent;
import rpg.core.dungeon.events.SpawnableEventType;
import rpg.core.dungeon.events.fight.Fight;

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

	public Dungeon() {

	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Room[][] getRooms() {
		return rooms;
	}

	public Room getStartRoom() {
		return startRoom;
	}

	public DungeonType getDungType() {
		return dungType;
	}

	public void setDungType(DungeonType dungType) {
		this.dungType = dungType;
	}

	public DungeonSize getSize() {
		return size;
	}

	public void setSize(DungeonSize size) {
		this.size = size;
	}

	public void setStartRoom(Room startRoom) {
		this.startRoom = startRoom;
	}

	public void setRooms(Room[][] rooms) {
		this.rooms = rooms;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public void setStartingRoom() {
		startRoom = getEnterableRooms().get(new Random().nextInt(getEnterableRooms().size()));
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
		List<Room> elements = getEnterableRooms();
		elements.remove(startRoom);
		return elements;
	}

	public List<Room> getEnterableRooms() {
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
		for (Room r : getEnterableRooms()) {
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

	public List<Enterable> getAllEnterablesExcludingStarting() {
		List<Enterable> enterables = getAllEnterables();
		enterables.remove(startRoom);
		return enterables;
	}

	public List<Enterable> getAllCorSections() {
		List<Enterable> enterables = new ArrayList<>();
		for (Room r : getEnterableRooms()) {
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
	
	public List<Corridor>getAllCorridors(){
		List<Corridor> corridors = new ArrayList<>();
		for (Room room : getAllRoomsAsList()) {
			for (Corridor corridor : room.getCorridors()) {
				if(!corridors.contains(corridor)&&!corridors.stream().anyMatch(e->e.isSameCorridor(corridor))){
					corridors.add(corridor);
				}
			}
		}
		return corridors;
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
		List<Corridor> enterables = new ArrayList<>();
		for (Room room : getEnterableRooms()) {
			displayEnterable(room);
			for (Corridor c : room.getCorridors()) {
				if (!enterables.contains(c)) {
					enterables.add(c);
				} else {
					continue;
				}
				for (CorridorSection cs : c.getSections()) {
					displayEnterable(cs);
				}
			}
		}
	}

	public void displayEnterable(Enterable e) {
		e.display();
		System.out.println(e.getEvents());
		for (SpawnEvent event : e.getEvents()) {
			if (event.getSpawnType() == SpawnableEventType.FIGHT) {
				Fight fight = (Fight) event;
				fight.getEnemyParty();
			}
		}

	}

}
