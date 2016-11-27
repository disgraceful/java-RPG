package com.disgrace.ddripoff.dungeon;

import java.util.ArrayList;
import java.util.List;

public class Room extends Enterable implements Neighbour {
	private RoomAdds adds = new RoomAdds();
	// public boolean visited = false;
	// public boolean partyHere = false;
	private ArrayList<Room> neighbours = new ArrayList<Room>();
	private ArrayList<Corridor> corridors = new ArrayList<Corridor>();

	@Override
	public void setNeighbour(Enterable enterable) {
		if (neighbours.size() < 4 && enterable instanceof Room) {
			Room room = (Room) enterable;
			this.neighbours.add(room);
		}
	}

	public RoomAdds getAdds() {
		return adds;
	}

	public ArrayList<Room> getNeighbours() {
		return neighbours;
	}

	public List<Corridor> getCorridors() {
		return corridors;
	}

	public void setCorridor(Corridor corridor) {
		if (corridors.size() < 4) {
			this.corridors.add(corridor);
		}
	}

	// @Override
	// public void enter() {
	// visited = true;
	// partyHere = true;
	// System.out.println("you have visited " + this.toString());
	// }

	// @Override
	// public void leave() {
	// partyHere = false;
	// System.out.println("you have left " + this.toString());
	// }

	public Corridor getCorridor(Room room) {
		for (Corridor c : corridors) {
			if ((c.begin == this || c.end == this) && (c.begin == room || c.end == room)) {
				return c;
			}
		}
		System.out.println("cant find that corridor");
		return null;
	}

	// @Override
	// public boolean canGoTo(Enterable e) {
	// return neighbours.contains(e);// | enterables.contains(e);
	// }

	// @Override
	// public String toString() {
	// return " room# " + this.hashCode() + " " + visited + " visited ";
	// }

	public boolean hasEntrance() {
		return getAdds().value == 1 ? false : true;
	}

	public boolean hasNoNeighbours() {
		for (Room r : neighbours) {
			if (r.neighbours.size() == 1) {
				this.display();
				System.out.println("has no neighbours");
				return true;
			}
		}
		return false;
	}

	public boolean isConnectedBy(Corridor corridor) {
		for (Corridor c : corridors) {
			if (c.isSameCorridor(corridor)) {
				return true;
			}
		}
		return false;
	}

	public void display() {
		System.out.println("Room " + adds.y + " " + adds.x);
	}

	public void displayCorridors() {
		System.out.println("Corridors: ");
		if (corridors.size() <= 0) {
			System.out.println("none");
		}
		for (Corridor c : corridors) {
			c.display();
		}
	}

	@Override
	public void displayNeighbours() {
		System.out.println("Neighbours: ");
		if (neighbours.size() <= 0) {
			System.out.println("none");
		}
		for (Room r : neighbours) {
			r.display();
		}

	}
}
