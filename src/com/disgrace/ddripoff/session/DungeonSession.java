package com.disgrace.ddripoff.session;

import com.disgrace.ddripoff.characters.shared.Party;
import com.disgrace.ddripoff.dungeon.Dungeon;
import com.disgrace.ddripoff.dungeon.Enterable;
import com.disgrace.ddripoff.dungeon.Room;
import com.disgrace.ddripoff.spawn.SpawnEvent;

public class DungeonSession {
	private boolean active;
	private Dungeon dungeon;
	private Party chosenParty;
	private Room startRoom;
	private Enterable currentRoom;
		
	public DungeonSession(Dungeon dungeon,Party party){
		this.dungeon = dungeon;
		chosenParty = party;
		startRoom = dungeon.getStartRoom();
	}
	
	public void startDungeon(){
		startRoom.enter();
		currentRoom = startRoom;
	}
	
	public void goToEnterable(Enterable destination,Enterable current){
		current.leave();
		destination.enter();
		currentRoom = destination;
	}
	
	public void interactWith(SpawnEvent event){
		event.trigger();
	}
}
