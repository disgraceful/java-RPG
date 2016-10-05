package com.disgrace.ddripoff.locations.dungeons.components;

import java.util.ArrayList;
import java.util.List;

public class Corridor {
	Room begin;
	Room end;
	List<CorridorSection> sections;

	public Corridor() {
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
	}

	public void setCorridor(Room begin, Room end) {
		this.begin = begin;
		this.end = end;
		// System.out.println("This Corridor unites " + this.begin.toString() + " and " + this.end.toString());
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

		// Iterator<CorridorSection> iter = sections.iterator();
		// while(iter.hasNext()){
		// CorridorSection section = iter.next();
		//
		// }
	}

}
