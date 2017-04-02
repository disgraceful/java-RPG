package com.disgrace.ddripoff.dungeon;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Desert extends Dungeon {
	
	public Desert(DungeonSize size){
		super(size);
		dungType = DungeonType.DESERT;
	}
}
