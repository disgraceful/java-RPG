package com.disgrace.ddripoff.dungeon;

import java.util.HashSet;
import java.util.Set;

import com.disgrace.ddripoff.spawn.SpawnEvent;
import com.disgrace.ddripoff.spawn.SpawnableEventType;

public abstract class Enterable {
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
		if (event != null && !containsSpawnType(event.getSpawnType())) {
			events.add(event);
			return;
		}
		System.out.println("This location already contains a event of this type or was null");
	}

	public void enter() {
		visited = true;
		partyHere = true;
		events.stream().filter(e -> e.getSpawnType() == SpawnableEventType.FIGHT).forEach(e -> {
			e.trigger();
			e.setTriggered(false);
		});
	}

	public void leave() {
		partyHere = false;
	}

	public abstract void display();

	public boolean containsSpawnType(SpawnableEventType type) {
		return events.stream().anyMatch(e -> e.getSpawnType() == type);
	}
	
	public void displayUntriggeredEvents(){
		if(events.stream().filter(e->!e.isTriggered()).count()>0){
			//TODO display
			//events.stream().filter(e->!e.isTriggered()).forEach();
		}else{
			System.out.println("No events in this Enterable");
		}
	}
}
