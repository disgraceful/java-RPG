package com.disgrace.ddripoff.session;

import java.util.Iterator;

import com.disgrace.ddripoff.characters.Party;
import com.disgrace.ddripoff.locations.dungeons.Dungeon;
import com.disgrace.ddripoff.locations.dungeons.components.Corridor;
import com.disgrace.ddripoff.locations.dungeons.components.CorridorSection;
import com.disgrace.ddripoff.locations.dungeons.components.Room;

public final class DungeonSession {
	static boolean active;
	int light = 0;
	public Dungeon dungeon;
	public Party chosenParty = new Party();
		
	public DungeonSession(Dungeon dungeon){
		this.dungeon = dungeon;
	}
	
//	public DungeonSession(Dungeon dungeon,Party party){
//		this.dungeon = dungeon;
//		chosenParty = party;
//	}
	
	public void startRoomAdventure(Room destination,Room current){
		current.leave();
		Corridor cor = current.getCorridor(destination);
		Iterator iter = cor.getSections().iterator();
		while(iter.hasNext()){
			CorridorSection cs =  (CorridorSection) iter.next();
			cs.enter();
			cs.leave();
			iter.remove();
		}
		destination.enter();
	} 
	
	
}
