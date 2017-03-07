package com.disgrace.ddripoff.tests;

import com.disgrace.ddripoff.characters.heroes.Hero;
import com.disgrace.ddripoff.hub.MercenaryCoach;

public class TestTown {

	public static void testCoach() {
		MercenaryCoach s = new MercenaryCoach();
		s.spawnVenturers();
		for (Hero h : s.getVenturers()) {
			System.out.println(h.hashCode());

		}
	}
	
	
	
}
