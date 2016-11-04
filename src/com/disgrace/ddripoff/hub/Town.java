package com.disgrace.ddripoff.hub;

import javax.xml.stream.Location;

public class Town {
	private static Blacksmith BLACKSMITH;
	private static SaviorsChurch CHURCH;
	private static VenturerCoach VENTURERS;

	static {
		BLACKSMITH = new Blacksmith();
		CHURCH = new SaviorsChurch();
		VENTURERS = new VenturerCoach();
	}
	
	
}
