package com.disgrace.ddripoff.locations.dungeons.components;

import java.util.ArrayList;

public class Room implements Enterable {
	private Room northNeighbour;
	private Room southNeighbour;
	private Room westNeighbour;
	private Room eastNeighbour;

	private ArrayList<Room> neighbours = new ArrayList<Room>();
	//private ArrayList<Enterable> enterables = new ArrayList<>();
	private ArrayList<Corridor> corridors = new ArrayList<>();
	
//	private Corridor northCor;
//	private Corridor southCor;
//	private Corridor westCor;
//	private Corridor eastCor;

	public boolean visited = false;
	public boolean partyHere = false;

	public ArrayList<Room> getNeighbours() {
		return neighbours;
	}
	
//	public ArrayList<Enterable> getEnterables(){
//		return enterables;
//	}
	
	public Room getNorthNeig(){
		return northNeighbour;
	}
	
	public Room getSouthNeig(){
		return southNeighbour;
	}
	
	public Room getWestNeig(){
		return westNeighbour;
	}
	
	public Room getEastNeig(){
		return eastNeighbour;
	}
	
	public void setNeigbour(Room room, RoomSide side) {
		if (room != this && room != null) {
			switch (side) {
			case SOUTH:
				if (southNeighbour == null) {
					southNeighbour = room;
					room.setNeigbour(this, RoomSide.NORTH);
					//southCor = new Corridor();
					//southCor.setCorridor(this, room);
					Corridor cor = new Corridor();
					cor.setCorridor(this, room);
					corridors.add(cor);
					neighbours.add(southNeighbour);
					//enterables.add(southCor.getSections().get(0));
					//System.out.println(this.toString() + "has south neighbour " + room.toString());
				}
				break;
			case NORTH:
				if (northNeighbour == null) {
					northNeighbour = room;
					room.setNeigbour(this, RoomSide.SOUTH);
//					northCor = new Corridor();
//					northCor.setCorridor(this, room);
					Corridor cor = new Corridor();
					cor.setCorridor(this, room);
					corridors.add(cor);
					neighbours.add(northNeighbour);
					//enterables.add(northCor.getSections().get(0));
					//System.out.println(this.toString() + "has north neighbour " + room.toString());
				}
				break;
			case EAST:
				if (eastNeighbour == null) {
					eastNeighbour = room;
					room.setNeigbour(this, RoomSide.WEST);
//					eastCor = new Corridor();
//					eastCor.setCorridor(this, room);
					Corridor cor = new Corridor();
					cor.setCorridor(this, room);
					corridors.add(cor);
					neighbours.add(eastNeighbour);
					//enterables.add(eastCor.getSections().get(0));
				//	System.out.println(this.toString() + "has east neighbour " + room.toString());
				}
				break;
			case WEST:
				if (westNeighbour == null) {
					westNeighbour = room;
					room.setNeigbour(this, RoomSide.EAST);
//					westCor = new Corridor();
//					westCor.setCorridor(this, room);
					Corridor cor = new Corridor();
					cor.setCorridor(this, room);
					corridors.add(cor);
					neighbours.add(westNeighbour);
					//enterables.add(westCor.getSections().get(0));
					//System.out.println(this.toString() + "has west neighbour " + room.toString());
				}
				break;
			}
		}
	}

	@Override
	public void enter() {
		visited = true;
		partyHere = true;
		System.out.println("you have visited " + this.toString());
	}

	@Override
	public void leave() {
		partyHere = false;
		System.out.println("you have left " + this.toString());
	}

	public void displayNeighbours() {
		for(Enterable r : neighbours){
			if(this.northNeighbour == r){
				System.out.println("north ");
			}else if(this.southNeighbour == r){
				System.out.println("south ");
			}else if(this.westNeighbour == r){
				System.out.println("west ");
			}else if(this.eastNeighbour == r){
				System.out.println("east");
			}
			System.out.println(r.toString());
		}
	}
	public Corridor getCorridor(Room r){
		for(Corridor c: corridors){
			if((c.begin == this || c.end ==this) &&(c.begin == r ||c.end==r)){
				return c;
			}
		}
		System.out.println("cant find that corridor");
		return null;
	}
	
	@Override public boolean canGoTo(Enterable e) {
		 return neighbours.contains(e);// | enterables.contains(e);
	}
	
	@Override
	public String toString() {
		return " room# " + this.hashCode()+ " "  + visited + " visited ";
	}
}
