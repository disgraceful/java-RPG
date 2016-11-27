package com.disgrace.ddripoff.dungeon;

import java.util.HashSet;
import java.util.Set;

import com.disgrace.ddripoff.spawn.SpawnEvent;
import com.disgrace.ddripoff.spawn.SpawnableEventType;

public class Enterable {
	protected Set<SpawnEvent> events = new HashSet<>();

	public Set<SpawnEvent> getEvents() {
		return events;
	}

	public void addEvent(SpawnEvent event) {
		if (event != null) {
			events.add(event);
		}
	}

	public void enter() {
		for (SpawnEvent event : events) {
			event.trigger();
		}
	}

	// void enter();
	// void leave();
	// boolean canGoTo(Enterable e);
}
