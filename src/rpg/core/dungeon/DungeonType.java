package rpg.core.dungeon;

public enum DungeonType {
	DESERT("Desert"), RAIN_FOREST("Rain Forest"), RUINS("Ruins"), VOID("Void"), ABANONED_DREAM("Abandoned Dream");

	private DungeonType(String name) {
		this.name = name;
	}

	private final String name;
	public String getName(){
		return name;
	}

}
