package com.disgrace.ddripoff.utils;

import com.disgrace.ddripoff.locations.dungeons.Desert;
import com.disgrace.ddripoff.locations.dungeons.components.Dungeon;
import com.disgrace.ddripoff.session.DungeonSession;

public class TestDungeon {

	public static void testDung() {
		DungeonSession sess = new DungeonSession(new Desert(3));
		Dungeon exde = sess.dungeon;
		//exde.startingRoom
		
		//Corridor cor = new Corridor();
	}
}
