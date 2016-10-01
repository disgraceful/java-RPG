package com.disgrace.ddripoff.locations.hub;

import com.disgrace.ddripoff.locations.Location;

public class Town {
	private static Blacksmith BLACKSMITH;
	private static SaviorsChurch CHURCH;
	private static VenturerCoach VENTURERS;

	static {
		BLACKSMITH = new Blacksmith();
		CHURCH = new SaviorsChurch();
		VENTURERS = new VenturerCoach();
	}
	
	private void goTo(Location loc){
		
	}
}
