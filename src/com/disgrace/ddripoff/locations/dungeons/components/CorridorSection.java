package com.disgrace.ddripoff.locations.dungeons.components;

public class CorridorSection implements Enterable{
	private CorridorSection next;
	private CorridorSection prev;
	
	public void setNext(CorridorSection section){
		if(next==null){
			next = section;
			System.out.println(this.hashCode()+ " has next section " + next.hashCode());
		}
	}
	
	public void setPrev(CorridorSection section){
		if(prev== null){
			prev = section;
			System.out.println(this.hashCode()+ " has prev section " + prev.hashCode());
		}
	}
}
