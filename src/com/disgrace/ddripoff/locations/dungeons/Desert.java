package com.disgrace.ddripoff.locations.dungeons;

import com.disgrace.ddripoff.locations.Location;

public class Desert extends Dungeon implements Location{
	
	public Desert(int capacity){
		super(capacity);
		type = DungeonType.DESERT;
	}
}
