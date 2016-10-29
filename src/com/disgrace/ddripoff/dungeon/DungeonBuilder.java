package com.disgrace.ddripoff.dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DungeonBuilder {
	private Dungeon dungeon;
	private Room[][] rooms;
	private int xbound;
	private int ybound;
	private int minRooms;
	private int allRooms;

	public DungeonBuilder(Dungeon dungeon) {
		this.dungeon = dungeon;
		rooms = dungeon.rooms;
		xbound = dungeon.size.xbound;
		ybound = dungeon.size.ybound;
		minRooms = dungeon.size.minRooms;
		allRooms = dungeon.getRoomsAsList().size();
	}

	public void build() {
		initRooms();
		buildRoomRelations();
		buildLevel();
		dungeon.displayRooms(0);
	}

	private void initRooms() {
		for (int i = 0; i < ybound; i++) {
			for (int j = 0; j < xbound; j++) {
				rooms[i][j] = new Room();
				rooms[i][j].x = j;
				rooms[i][j].y = i;
			}
		}
	}

	private void buildRoomRelations() {
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

	private void buildLevel() {
		int tempRooms = allRooms;
		while (tempRooms > minRooms) {
			Room roomToDestroy = getRandomRoom();
			if (roomToDestroy.value == 1) {
				continue;
			}
			if (whereverOne(roomToDestroy) || hasNoNeighbours(roomToDestroy)) {
				roomToDestroy.display();
				System.out.println("cant destroy");
				continue;
			} else {
				roomToDestroy.value = 1;
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
		//return rooms[1][1];
	}

	private boolean whereverOne(Room room) {
		if (oneInList(getDiagonals(room,true))||oneInList(getDiagonals(room,false)) || oneInList(getColumn(room.x)) || oneInList(getRow(room.y))) {
			return true;
		}
		return false;
	}

	// private boolean outer(Room room) {
	// if (room.x == xbound-1 || room.x == 0 || room.y == 0 || room.y == ybound-1) {
	// return true;
	// }
	// return false;
	// }

	private boolean oneInList(List<Room> list) {
		int count = 0;
		if(list.size()==1){
			return false;
		}
		for (Room r : list) {
			if (r.value == 0) {
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
		int xcounter = room.x;
		int ycounter = room.y;
		if (side) {
			while (xcounter < xbound - 1 && ycounter < ybound - 1) {
				xcounter++;
				ycounter++;
				diagonalic.add(rooms[ycounter][xcounter]);
			}
			xcounter = room.x;
			ycounter = room.y;
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
			xcounter = room.x;
			ycounter = room.y;
			while (xcounter > 0 && ycounter < ybound - 1) {
				ycounter++;
				xcounter--;
				diagonalic.add(rooms[ycounter][xcounter]);
			}
		}
		return diagonalic;
	}
}
