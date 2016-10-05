package com.disgrace.ddripoff.locations.dungeons;

import java.util.ArrayList;

import com.disgrace.ddripoff.locations.Location;
import com.disgrace.ddripoff.locations.dungeons.components.Dungeon;
import com.disgrace.ddripoff.locations.dungeons.components.DungeonGenerator;
import com.disgrace.ddripoff.locations.dungeons.components.Room;

public class Desert extends Dungeon implements Location{
	
	public Desert(){
		rooms = new ArrayList<Room>();
		type = DungeonType.DESERT;
		DungeonGenerator.buildLevel(this);
	}
}
