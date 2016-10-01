package com.disgrace.ddripoff.locations;

import java.util.ArrayList;

public class Room {

	private Room northNeighbour;
	private Room southNeighbour;
	private Room westNeighbour;
	private Room eastNeighbour;
	
	private Corridor northCor;
	private Corridor southCor;
	private Corridor westCor;
	private Corridor eastCor;
	
	
	public void setNeigbour(Room room,RoomSide side) {
		if(room!=this&&room!=null){
			switch(side){
			case SOUTH:
				if(southNeighbour==null){
					southNeighbour = room;
					room.setNeigbour(this, RoomSide.NORTH);
					southCor = new Corridor();
					southCor.setCorridor(this, room);
					System.out.println(this.toString()+ "has south neighbour " + room.toString());
				}
				break;
			case NORTH:
				if(northNeighbour==null){
					northNeighbour = room;
					room.setNeigbour(this, RoomSide.SOUTH);
					northCor = new Corridor();
					northCor.setCorridor(this, room);
					System.out.println(this.toString()+ "has north neighbour " + room.toString());
				}
				break;
			case EAST:
				if(eastNeighbour==null){
					eastNeighbour = room;
					room.setNeigbour(this, RoomSide.WEST);
					eastCor = new Corridor();
					eastCor.setCorridor(this, room);
					System.out.println(this.toString()+ "has east neighbour " + room.toString());
				}
				break;
			case WEST:
				if(westNeighbour==null){
					westNeighbour = room;
					room.setNeigbour(this, RoomSide.EAST);
					westCor = new Corridor();
					westCor.setCorridor(this, room);
					System.out.println(this.toString()+ "has west neighbour " + room.toString());
				}
				break;
			}
		}
	}
	
	
	
	@Override public String toString(){
		return "room#" + this.hashCode();
	}
	
	
	
	// public int x, y;
	// public int value = 0;
	// public ArrayList<Room> neighbours = new ArrayList();

	// public Room(int x, int y) {
	// this.x = x;
	// this.y = y;
	// }
	//
	// private boolean ifNeighbour(Room r){
	// if(this.neighbours.contains(r)){
	// return true;
	// }
	// else{
	// return false;
	// }
	//
	// }
	//
	// public boolean ifNeighboursAlone(){
	// if(neighbours.size()>0){
	// for(Room room :neighbours){
	// if(room.ifNeighbour(this)&&room.neighbours.size()==1){
	// return true;
	// }
	// }
	// return false;
	// }
	// else{
	// return false;
	// }
	//
	// }

}
