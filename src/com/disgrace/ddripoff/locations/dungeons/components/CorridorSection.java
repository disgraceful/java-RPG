package com.disgrace.ddripoff.locations.dungeons.components;

import java.util.ArrayList;

public class CorridorSection implements Enterable {
	private CorridorSection next;
	private CorridorSection prev;

	private ArrayList<Enterable> neighbours = new ArrayList<Enterable>();

	public boolean visited = false;
	public boolean partyHere = false;

	public void setNext(CorridorSection section) {
		if (next == null) {
			next = section;
			neighbours.add(next);
			//System.out.println(this.hashCode() + " has next section " + next.hashCode());
		}
	}

	public void setPrev(CorridorSection section) {
		if (prev == null) {
			prev = section;
			neighbours.add(prev);
			//System.out.println(this.hashCode() + " has prev section " + prev.hashCode());
		}
	}

	@Override
	public void enter() {
		visited = true;
		partyHere = true;
		System.out.println("you have visited " + this.toString());
	}

	@Override
	public void leave() {
		partyHere = false;
		System.out.println("you have left " + this.toString());

	}

	public ArrayList<Enterable> getNeighbours() {
		return neighbours;
	}

	@Override
	public boolean canGoTo(Enterable e) {
		return false;
	}
}
