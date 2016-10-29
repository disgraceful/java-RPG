package com.disgrace.ddripoff.dungeon;

import java.util.ArrayList;
import java.util.List;

public class Corridor {
	Room begin;
	Room end;
	ArrayList<CorridorSection> sections;

	public Corridor(Room r1, Room r2) {
		sections = new ArrayList<CorridorSection>() {
			{
				add(new CorridorSection());
				add(new CorridorSection());
				add(new CorridorSection());
				add(new CorridorSection());
				add(new CorridorSection());
			}
		};
		setSections();
		this.begin = r1;
		this.end = r2;
	
	}
	
	private void setSections() {
		for (int i = 0; i < sections.size(); i++) {
			CorridorSection section = sections.get(i);
			if (i - 1 >= 0) {
				section.setPrev(sections.get(i - 1));
			}
			if (i + 1 < sections.size()) {
				section.setNext(sections.get(i + 1));
			}
		}
	}
	
	public ArrayList<CorridorSection> getSections(){
		return sections;
	}
}