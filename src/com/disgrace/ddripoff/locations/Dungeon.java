package com.disgrace.ddripoff.locations;

import java.util.ArrayList;

public class Dungeon {
	public ArrayList<Room> rooms;
	
	public Room getBy(int x,int y){
		for(Room r : rooms){
			if(r.x == x&& r.y == y){
				return r;
			}
		}
		return null;
	}
	
	public int getMaxIndex(){
		int max = 0;
		for(Room r: rooms){
			if(r.x>max){
				max = r.x;
			}
		}
		return max;
	}
	
	public Dungeon(ArrayList<Room> rooms){
		this.rooms =rooms;
	}
}
