package com.disgrace.ddripoff.session;

import com.disgrace.ddripoff.characters.shared.Party;
import com.disgrace.ddripoff.dungeon.Dungeon;
import com.disgrace.ddripoff.dungeon.Enterable;
import com.disgrace.ddripoff.dungeon.Room;
import com.disgrace.ddripoff.spawn.SpawnEvent;

public class DungeonSession {
	private static boolean active;
	private static Dungeon dungeon;
	private static Party chosenParty;
	private static Room startRoom;
	private static Enterable currentRoom;
	
	private static final DungeonSession DUNGEON_SESSION_INSTANCE = new DungeonSession();
	private DungeonSession(){
	}
	
	public static void initiateSession(Dungeon dungeon,Party party){
		DungeonSession.dungeon = dungeon;
		chosenParty = party;
		startRoom = dungeon.getStartRoom();
	}
	
	public static void startDungeon(){
		startRoom.enter();
		currentRoom = startRoom;
	}
	
	public static void goToEnterable(Enterable destination,Enterable current){
		current.leave();
		destination.enter();
		currentRoom = destination;
	}
	
	public void interactWith(SpawnEvent event){
		event.trigger();
	}
}
