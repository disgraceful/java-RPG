package com.disgrace.ddripoff.dungeon;

import java.util.HashSet;
import java.util.Set;

import com.disgrace.ddripoff.spawn.SpawnEvent;

public class Enterable {
	protected Set<SpawnEvent> events = new HashSet<>();
	protected boolean partyHere = false;
	protected boolean visited = false;

	public boolean isPartyHere() {
		return partyHere;
	}

	public void setPartyHere(boolean partyHere) {
		this.partyHere = partyHere;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Set<SpawnEvent> getEvents() {
		return events;
	}

	public void addEvent(SpawnEvent event) {
		if (event != null) {
			events.add(event);
		}
	}

	public void enter() {
		visited = true;
		partyHere = true;
		for (SpawnEvent event : events) {
			event.trigger();
		}
	}
	
	public void leave(){
		partyHere = false;
	}
}
