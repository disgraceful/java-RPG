package com.disgrace.ddripoff.dungeon;

import java.util.ArrayList;
import java.util.List;

public class Corridor {
	Room begin;
	Room end;
	List<CorridorSection> sections;

	public Corridor(Room r1, Room r2) {
		this(r1, r2, 5);
	}
	
	public Corridor(Room r1, Room r2,int sectionCap){
		sections = new ArrayList<>();
		for (int i = 0; i < sectionCap; i++) {
			sections.add(new CorridorSection());			
		}
		setSections();
		this.begin = r1;
		this.end = r2;
	}
	
	private void setSections() {
		for (int i = 0; i < sections.size(); i++) {
			if(i+1<sections.size()){
			sections.get(i).setNeighbour(sections.get(i+1));
			}
			if(i-1>=0){
				sections.get(i).setNeighbour(sections.get(i-1));
			}
		}
	}
	
	public List<CorridorSection> getSections(){
		return sections;
	}
	
	public void displaySections(){
		for(CorridorSection section:sections){
			section.display();
			section.displayNeighbours();
		}
	}
	
	public void display(){
		System.out.println("Corridor "+ this.hashCode()+ " unites ");
		begin.display();
		end.display();
		
	}

	public boolean isSameCorridor(Corridor corridor) {
		if((begin == corridor.begin&&end ==corridor.end)||(begin == corridor.end&&end == corridor.begin)){
			return true;
		}
		return false;
	}
}