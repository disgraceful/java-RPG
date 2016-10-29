package com.disgrace.ddripoff.dungeon;

public enum DungeonSize {
	SMALL("Small",2,3,4),MEDIUM("Medium",3,4,9),LARGE("Large",3,6,13);
	
	private String name; 
	int xbound;
	int ybound;
	int minRooms;
	
	private DungeonSize(String name, int height, int width,int rooms){
		this.name = name;
		ybound = height;
		xbound = width;
		minRooms = rooms;
	}
	
	@Override public String toString(){
		return name;
	}
	
	
	
}
