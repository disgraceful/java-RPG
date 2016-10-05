package com.disgrace.ddripoff.locations.dungeons.components;

public class Room implements Enterable {
	private Room northNeighbour;
	private Room southNeighbour;
	private Room westNeighbour;
	private Room eastNeighbour;

	private Corridor northCor;
	private Corridor southCor;
	private Corridor westCor;
	private Corridor eastCor;

	public boolean visited = false;
	public boolean partyHere = false;

	public void setNeigbour(Room room, RoomSide side) {
		if (room != this && room != null) {
			switch (side) {
			case SOUTH:
				if (southNeighbour == null) {
					southNeighbour = room;
					room.setNeigbour(this, RoomSide.NORTH);
					southCor = new Corridor();
					southCor.setCorridor(this, room);
					System.out.println(this.toString() + "has south neighbour " + room.toString());
				}
				break;
			case NORTH:
				if (northNeighbour == null) {
					northNeighbour = room;
					room.setNeigbour(this, RoomSide.SOUTH);
					northCor = new Corridor();
					northCor.setCorridor(this, room);
					System.out.println(this.toString() + "has north neighbour " + room.toString());
				}
				break;
			case EAST:
				if (eastNeighbour == null) {
					eastNeighbour = room;
					room.setNeigbour(this, RoomSide.WEST);
					eastCor = new Corridor();
					eastCor.setCorridor(this, room);
					System.out.println(this.toString() + "has east neighbour " + room.toString());
				}
				break;
			case WEST:
				if (westNeighbour == null) {
					westNeighbour = room;
					room.setNeigbour(this, RoomSide.EAST);
					westCor = new Corridor();
					westCor.setCorridor(this, room);
					System.out.println(this.toString() + "has west neighbour " + room.toString());
				}
				break;
			}
		}
	}

	@Override
	public void enter() {
		visited = true;
		partyHere = true;
		System.out.println();
	}

	@Override
	public void leave() {
		partyHere = false;
	}
	
	@Override
	public void goTo(Enterable destination){
		destination.enter();
	}

	@Override
	public String toString() {
		return "room# " + this.hashCode();
	}

}
