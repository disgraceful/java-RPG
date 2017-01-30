package com.disgrace.ddripoff.tests;

import com.disgrace.ddripoff.characters.heroes.Hero;
import com.disgrace.ddripoff.hub.VenturerCoach;

public class TestTown {

	public static void testCoach() {
		VenturerCoach s = new VenturerCoach();
		s.spawnVenturers();
		for (Hero h : s.getVenturers()) {
			System.out.println(h.hashCode());

		}
	}
	
	
	
}
