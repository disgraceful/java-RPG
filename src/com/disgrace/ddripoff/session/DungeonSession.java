package com.disgrace.ddripoff.session;

import java.util.Iterator;

import com.disgrace.ddripoff.characters.shared.Party;
import com.disgrace.ddripoff.dungeon.Corridor;
import com.disgrace.ddripoff.dungeon.CorridorSection;
import com.disgrace.ddripoff.dungeon.Dungeon;
import com.disgrace.ddripoff.dungeon.Room;

public final class DungeonSession {
	static boolean active;
	public Dungeon dungeon;
	public Party chosenParty;
		
	public DungeonSession(Dungeon dungeon){
		this.dungeon = dungeon;
	}
	
	public DungeonSession(Dungeon dungeon,Party party){
		this.dungeon = dungeon;
		chosenParty = party;
	}
	
	public void startRoomAdventure(Room destination,Room current){
		dungeon.getSTART_ROOM().enter();
		Corridor cor = current.getCorridor(destination);
		Iterator iter = cor.getSections().iterator();
		while(iter.hasNext()){
			CorridorSection cs =  (CorridorSection) iter.next();
			//cs.enter();
			//cs.leave();
			iter.remove();
		}
		//destination.enter();
	} 
}
