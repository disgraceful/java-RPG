package rpg.core.dungeon.events;


import rpg.core.dungeon.Dungeon;

public class UniqueDungeonEventSpawner extends DungeonEventSpawner{

	private UniqueDungeonEventSpawner() {
	}
	
	public static void generate(Dungeon dungeon) {
		init(dungeon);
	}
}
