package com.disgrace.ddripoff.dungeon;

import java.util.ArrayList;
import java.util.Iterator;

public class CorridorSection implements Enterable {
	private ArrayList<Enterable> neighbours = new ArrayList<Enterable>();

	//public boolean visited = false;
	//public boolean partyHere = false;
	
	public CorridorSection(){}
	
	public ArrayList<Enterable> getNeighbours() {
		return neighbours;
	}
	
	public void setNeighbour(CorridorSection section){
		if(neighbours.size()<2){
			neighbours.add(section);
		}
	}
	
	public void display(){
		System.out.println("section# " + this.hashCode());
	}
	
	public void displayNeighbours(){
		System.out.println("Neighbours: ");
		for (Enterable section: neighbours) {
			CorridorSection temp = (CorridorSection)section;
			temp.display();	
		}
		System.out.println(" ");
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
//
//	}

	

//	@Override
//	public boolean canGoTo(Enterable e) {
//		return false;
//	}
}
