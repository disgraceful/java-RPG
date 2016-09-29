package com.disgrace.ddripoff.locations;

import java.util.ArrayList;

public class Dungeon {
	public static ArrayList<Room> rooms;
	
	static{
		rooms = new ArrayList<Room>();
	}
	
//	public Room getBy(int x,int y){
//		for(Room r : rooms){
//			if(r.x == x&& r.y == y){
//				return r;
//			}
//		}
//		return null;
//	}
//	
//	public int getMaxIndex(){
//		int max = 0;
//		for(Room r: rooms){
//			if(r.x>max){
//				max = r.x;
//			}
//		}
//		return max;
//	}
	
}
