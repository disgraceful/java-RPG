package com.disgrace.ddripoff.dungeon;

import java.util.ArrayList;
import java.util.List;

public class Room implements Enterable {
	
	public int x;
	public int y;
	public int value;

	public boolean visited = false;
	public boolean partyHere = false;
	private ArrayList<Room> neighbours = new ArrayList<Room>();
	private ArrayList<Corridor> corridors = new ArrayList<>();

	public void setNeighbour(Room r) {
		if (neighbours.size() < 4) {
			this.neighbours.add(r);
		}
	}

	public ArrayList<Room> getNeighbours() {
		return neighbours;
	}

//	@Override
//	public void enter() {
//		visited = true;
//		partyHere = true;
//		System.out.println("you have visited " + this.toString());
//	}

//	@Override
//	public void leave() {
//		partyHere = false;
//		System.out.println("you have left " + this.toString());
//	}

	public Corridor getCorridor(Room r) {
		for (Corridor c : corridors) {
			if ((c.begin == this || c.end == this) && (c.begin == r || c.end == r)) {
				return c;
			}
		}
		System.out.println("cant find that corridor");
		return null;
	}

//	@Override
//	public boolean canGoTo(Enterable e) {
//		return neighbours.contains(e);// | enterables.contains(e);
//	}

	@Override
	public String toString() {
		return " room# " + this.hashCode() + " " + visited + " visited ";
	}

	public void display(){
		System.out.println("Room "+ y+" "+ x );
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
	
	public void displayNeighbours(){
		System.out.println("Neighbours: ");
		for(Room r: neighbours){
			r.display();
		}
	}
}
