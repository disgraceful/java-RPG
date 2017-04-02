package com.disgrace.ddripoff.dungeon;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum DungeonSize {
	SMALL("Small",2,3,4,3),MEDIUM("Medium",3,4,9,8),LARGE("Large",3,6,13,12);
	
	private String name; 
	int xbound;
	int ybound;
	int minRooms;
	int fightAmount;
	
	private DungeonSize(String name, int height, int width,int rooms,int fightAmount){
		this.name = name;
		ybound = height;
		xbound = width;
		minRooms = rooms;
		this.fightAmount = fightAmount;
	}
	
	@Override public String toString(){
		return name;
	}
	
	
	
}
