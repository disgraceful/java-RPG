package com.disgrace.ddripoff.locations;

import java.util.ArrayList;

public class Room {

	public int x, y;
	public int value = 0;
	public ArrayList<Room> neighbours = new ArrayList();

	public Room(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	private boolean ifNeighbour(Room r){
		if(this.neighbours.contains(r)){
			return true;
		}
		else{
			return false;
		}
		
	}

	public boolean ifNeighboursAlone(){
		if(neighbours.size()>0){
			for(Room room :neighbours){
				if(room.ifNeighbour(this)&&room.neighbours.size()==1){
					return true;
				}
			}
			return false;
		}
		else{
			return false;
		}
		
	}
}
