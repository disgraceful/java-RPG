package com.disgrace.ddripoff.dungeon;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum DungeonType {
	DESERT("Desert"), RAIN_FOREST("Rain Forest"), RUINS("Ruins"), WASTES("Wastes"), ABANONED_DREAM("Abandoned Dream");

	private DungeonType(String name) {
		this.name = name;
	}

	private final String name;
	public String getName(){
		return name;
	}

}
