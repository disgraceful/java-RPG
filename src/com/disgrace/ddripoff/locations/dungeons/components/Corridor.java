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
	}

	public void setCorridor(Room begin, Room end) {
		this.begin = begin;
		this.end = end;
		//System.out.println("This Corridor unites " + this.begin.toString() + " and " + this.end.toString());
	}
}
