package com.disgrace.ddripoff.dungeon;

import java.util.ArrayList;
import java.util.Iterator;

public class CorridorSection extends Enterable implements Neighbour{
	private ArrayList<Enterable> neighbours = new ArrayList<Enterable>();
	
	public ArrayList<Enterable> getNeighbours() {
		return neighbours;
	}
	
	@Override
	public void setNeighbour(Enterable enterable){
		if(neighbours.size()<2 && enterable instanceof CorridorSection){
			CorridorSection section = (CorridorSection)enterable;
			neighbours.add(section);
		}
	}
	
	public void display(){
		System.out.println("section# " + this.hashCode());
	}
	
	@Override
	public void displayNeighbours(){
		System.out.println("Neighbours: ");
		for (Enterable section: neighbours) {
			CorridorSection temp = (CorridorSection)section;
			temp.display();	
		}
		System.out.println(" ");
	}

}
