package com.disgrace.ddripoff.session;

import java.util.HashSet;
import java.util.Set;

import com.disgrace.ddripoff.characters.shared.Party;
import com.disgrace.ddripoff.dungeon.Dungeon;
import com.disgrace.ddripoff.dungeon.Enterable;
import com.disgrace.ddripoff.dungeon.Room;
import com.disgrace.ddripoff.items.Item;
import com.disgrace.ddripoff.spawn.SpawnEvent;

public class DungeonSession {
	private boolean active;
	private Dungeon dungeon;
	private Party chosenParty;
	private Room startRoom;
	private Enterable currentRoom;
	private Set<Item> inventory = new HashSet<>();

	private static final DungeonSession DUNGEON_SESSION_INSTANCE = new DungeonSession();

	private DungeonSession() {
	}

	public static DungeonSession getSession() {
		return DUNGEON_SESSION_INSTANCE;
	}

	public void initiateSession(Dungeon dungeon, Party party) {
		this.dungeon = dungeon;
		chosenParty = party;
		startRoom = dungeon.getStartRoom();
	}

	public void startDungeon() {
		startRoom.enter();
		currentRoom = startRoom;
	}

	public void goToEnterable(Enterable destination, Enterable current) {
		current.leave();
		destination.enter();
		currentRoom = destination;
	}

	public void interactWith(SpawnEvent event) {
		event.trigger();
	}

	public void engageInFight(Party bad) {

	}
}
