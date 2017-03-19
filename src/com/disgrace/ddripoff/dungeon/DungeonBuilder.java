package com.disgrace.ddripoff.dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DungeonBuilder {
	private final Dungeon dungeon;
	private final Room[][] rooms;
	private final int xbound;
	private final int ybound;
	private final int minRooms;
	private final int allRooms;
	private DungeonEventSpawner des;

	public DungeonBuilder(Dungeon dungeon) {
		this.dungeon = dungeon;
		rooms = dungeon.getRooms();
		xbound = dungeon.size.xbound;
		ybound = dungeon.size.ybound;
		minRooms = dungeon.size.minRooms;
		allRooms = dungeon.getAllRoomsAsList().size();
	}

	public void build() {
		setRoomRelations();
		buildLevel();
		setRoomCorridors();
		dungeon.setStartingRoom();
		des = new DungeonEventSpawner(dungeon.getAllEnterables());
		des.generateSpawns();
		System.out.println("starting room: ");
		dungeon.getStartRoom().display();
		dungeon.displayEnterablesValue();
	}

	private void setRoomRelations() {
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

	private void setRoomCorridors() {
		for (Room curRoom : dungeon.getAllRoomsAsList()) {
			if (curRoom.hasEntrance()) {
				for (Room neighRoom : curRoom.getNeighbours()) {
					Corridor corridor = new Corridor(curRoom, neighRoom);
					if (neighRoom.hasEntrance() && !curRoom.isConnectedBy(corridor)) {
						curRoom.setCorridor(corridor);
						neighRoom.setCorridor(corridor);
					}
				}
			}
		}

	}

	private void buildLevel() {
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

	private boolean hasNoNeighbours(Room room) {
		return room.hasNoNeighbours();
	}

	private Room getRandomRoom() {
		int y = new Random().nextInt(ybound);
		int x = new Random().nextInt(xbound);
		return rooms[y][x];
		// return rooms[1][1];
	}

	private boolean whereverOne(Room room) {
		if (oneInList(getDiagonals(room, true)) || oneInList(getDiagonals(room, false))
				|| oneInList(getColumn(room.getAdds().x)) || oneInList(getRow(room.getAdds().y))) {
			return true;
		}
		return false;
	}

	private boolean oneInList(List<Room> list) {
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

	private List<Room> getColumn(int colNum) {
		if (colNum > ybound) {
			System.err.println("COL NUM OUT OF INDEX");
			return null;
		}
		List<Room> column = new ArrayList<>();
		for (int i = 0; i < ybound; i++) {
			column.add(rooms[i][colNum]);
		}
		return column;
	}

	private List<Room> getRow(int rowNum) {
		if (rowNum > ybound) {
			System.err.println("ROW NUM OUT OF INDEX");
			return null;
		}
		List<Room> row = new ArrayList<>();
		for (int j = 0; j < xbound; j++) {
			row.add(rooms[rowNum][j]);
		}
		return row;
	}

	private List<Room> getDiagonals(Room room, boolean side) {
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
