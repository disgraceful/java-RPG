package com.disgrace.ddripoff.utils;

import com.disgrace.ddripoff.characters.Hero;
import com.disgrace.ddripoff.locations.hub.VenturerCoach;

public class TestTown {
	
	public static void testCoach(){
		VenturerCoach s = new VenturerCoach();
		s.spawnVenturers();
		for(Hero h :s.getVenturers()){
			System.out.println(h.hashCode());
			
		}
		
		
		
		
	}
}
