package com.disgrace.ddripoff.session;

import com.disgrace.ddripoff.characters.Party;
import com.disgrace.ddripoff.locations.dungeons.components.Dungeon;

public final class DungeonSession {
	static boolean active;
	int light = 0;
	public Dungeon dungeon;
	Party chosenParty = new Party();
		
	public DungeonSession(Dungeon dungeon){
		this.dungeon = dungeon;
	}
	
//	public DungeonSession(Dungeon dungeon,Party party){
//		this.dungeon = dungeon;
//		chosenParty = party;
//	}

	 
	static void start(){
		
	} 
}
