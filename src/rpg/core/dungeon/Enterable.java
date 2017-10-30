package rpg.core.dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import rpg.core.spawn.events.SpawnEvent;
import rpg.core.spawn.events.SpawnableEventType;

public abstract class Enterable {
	protected List<SpawnEvent> events = new ArrayList<>();
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

	public List<SpawnEvent> getEvents() {
		return events;
	}

	public void addEvent(SpawnEvent event) {
		events.add(event);
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

	public boolean canAddSpawnEvent(SpawnableEventType type) {
		return !containsConflictSpawnType(type) && !containsSpawnType(type);
	}

	public boolean containsSpawnType(SpawnableEventType type) {
		return events.stream().anyMatch(e -> e.getSpawnType() == type);
	}

	private boolean containsConflictSpawnType(SpawnableEventType type) {
		return (type == SpawnableEventType.CURIO && containsSpawnType(SpawnableEventType.TREASURE))
				|| (type == SpawnableEventType.TREASURE && containsSpawnType(SpawnableEventType.TREASURE));
	}

	public void displayUntriggeredEvents() {
		if (events.stream().filter(e -> !e.isTriggered()).count() > 0) {
			// TODO display
			// events.stream().filter(e->!e.isTriggered()).forEach();
		} else {
			System.out.println("No events in this Enterable");
		}
	}
}
