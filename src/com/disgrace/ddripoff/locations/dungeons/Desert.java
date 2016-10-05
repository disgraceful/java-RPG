package com.disgrace.ddripoff.locations.dungeons;

import com.disgrace.ddripoff.locations.Location;
import com.disgrace.ddripoff.locations.dungeons.components.Dungeon;
import com.disgrace.ddripoff.locations.dungeons.components.DungeonGenerator;

public class Desert extends Dungeon implements Location{
	
	public Desert(int capacity){
		super(capacity);
		type = DungeonType.DESERT;
		DungeonGenerator.buildLevel(this);
	}
}
