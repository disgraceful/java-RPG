package com.disgrace.ddripoff.dungeon;

import java.util.ArrayList;
import java.util.List;

public class CorridorSection extends Enterable implements Neighbour{
	private List<Enterable> neighbours = new ArrayList<>();
	
	public List<Enterable> getNeighbours() {
		return neighbours;
	}
	
	@Override
	public void setNeighbour(Enterable enterable){
		if(neighbours.size()<2 && enterable instanceof CorridorSection){
			CorridorSection section = (CorridorSection)enterable;
			neighbours.add(section);
		}
	}
	
	@Override
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
