package rpg.core.dungeon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DungeonBuilder {
	protected static Dungeon dungeon;
	private static Room[][] rooms;
	private static int xbound;
	private static int ybound;
	private static int minRooms;
	private static int allRooms;

	protected DungeonBuilder() {
	}
	
	protected static void init(Dungeon buildingDungeon){
		dungeon = buildingDungeon;
		rooms = buildingDungeon.getRooms();
		xbound = buildingDungeon.size.xbound;
		ybound = buildingDungeon.size.ybound;
		minRooms = buildingDungeon.size.minRooms;
		allRooms = buildingDungeon.getAllRoomsAsList().size();
	}

	public static void build(Dungeon buildingDungeon) {
		init(buildingDungeon);
		setRoomRelations();
		buildLevel();
		setRoomCorridors();
		dungeon.setStartingRoom();
		
	}

	protected static void setRoomRelations() {
		for (int i = 0; i < ybound; i++) {
			for (int j = 0; j < xbound; j++) {
				if (i + 1 < ybound) {
					rooms[i][j].setNeighbour(rooms[i + 1][j]);
				}
				if (i - 1 >= 0) {
					rooms[i][j].setNeighbour(rooms[i - 1][j]);
				}
				if (j + 1 < xbound) {
					rooms[i][j].setNeighbour(rooms[i][j + 1]);
				}
				if (j - 1 >= 0) {
					rooms[i][j].setNeighbour(rooms[i][j - 1]);
				}
			}
		}
	}

	protected static void setRoomCorridors() {
		for (Room curRoom : dungeon.getEnterableRooms()) {
			for (Room neighRoom : curRoom.getNeighbours()) {
				Corridor corridor = new Corridor(curRoom, neighRoom);
				if (neighRoom.hasEntrance() && !curRoom.isConnectedBy(corridor)) {
					curRoom.setCorridor(corridor);
					neighRoom.setCorridor(corridor);
				}
			}
		}
	}

	private static void buildLevel() {
		int tempRooms = allRooms;
		while (tempRooms > minRooms) {
			Room roomToDestroy = getRandomRoom();
			if (roomToDestroy.getAdds().value == 1) {
				continue;
			}
			if (whereverOne(roomToDestroy) || hasNoNeighbours(roomToDestroy)) {
				roomToDestroy.display();
				System.out.println("cant destroy");
				continue;
			} else {
				roomToDestroy.getAdds().value = 1;
				roomToDestroy.display();

				tempRooms--;
				System.out.println("destroyed");
			}
		}
	}

	private static boolean hasNoNeighbours(Room room) {
		return room.hasNoNeighbours();
	}

	private static Room getRandomRoom() {
		int y = new Random().nextInt(ybound);
		int x = new Random().nextInt(xbound);
		return rooms[y][x];
	}

	private static boolean whereverOne(Room room) {
		if (oneInList(getDiagonals(room, true)) || oneInList(getDiagonals(room, false))
				|| oneInList(getColumn(room.getAdds().x)) || oneInList(getRow(room.getAdds().y))) {
			return true;
		}
		return false;
	}

	private static boolean oneInList(List<Room> list) {
		int count = 0;
		if (list.size() == 1) {
			return false;
		}
		for (Room r : list) {
			if (r.getAdds().value == 0) {
				count++;
			}
		}
		if (count == 1) {
			return true;
		}
		return false;
	}

	private static List<Room> getColumn(int colNum) {
		if (colNum > ybound) {
			System.err.println("COL NUM OUT OF INDEX");
			return Collections.emptyList();
		}
		List<Room> column = new ArrayList<>();
		for (int i = 0; i < ybound; i++) {
			column.add(rooms[i][colNum]);
		}
		return column;
	}

	private static List<Room> getRow(int rowNum) {
		if (rowNum > ybound) {
			System.err.println("ROW NUM OUT OF INDEX");
			return Collections.emptyList();
		}
		List<Room> row = new ArrayList<>();
		for (int j = 0; j < xbound; j++) {
			row.add(rooms[rowNum][j]);
		}
		return row;
	}

	private static List<Room> getDiagonals(Room room, boolean side) {
		List<Room> diagonalic = new ArrayList<>();
		diagonalic.add(room);
		int xcounter = room.getAdds().x;
		int ycounter = room.getAdds().y;
		if (side) {
			while (xcounter < xbound - 1 && ycounter < ybound - 1) {
				xcounter++;
				ycounter++;
				diagonalic.add(rooms[ycounter][xcounter]);
			}
			xcounter = room.getAdds().x;
			ycounter = room.getAdds().y;
			while (xcounter > 0 && ycounter > 0) {
				xcounter--;
				ycounter--;
				diagonalic.add(rooms[ycounter][xcounter]);
			}
		}
		if (!side) {
			while (xcounter < xbound - 1 && ycounter > 0) {
				xcounter++;
				ycounter--;
				diagonalic.add(rooms[ycounter][xcounter]);
			}
			xcounter = room.getAdds().x;
			ycounter = room.getAdds().y;
			while (xcounter > 0 && ycounter < ybound - 1) {
				ycounter++;
				xcounter--;
				diagonalic.add(rooms[ycounter][xcounter]);
			}
		}
		return diagonalic;
	}
}
