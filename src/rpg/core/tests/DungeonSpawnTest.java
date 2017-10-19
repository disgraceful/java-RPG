package rpg.core.tests;

import rpg.core.dungeon.Desert;
import rpg.core.dungeon.DungeonBuilder;
import rpg.core.dungeon.DungeonEventSpawner;
import rpg.core.dungeon.DungeonSize;
import rpg.core.spawn.CharacterFactory;

public class DungeonSpawnTest {
	static Desert dung = new Desert(DungeonSize.SMALL);
	



	public static void main(String[] args) {
		DungeonBuilder.build(dung);
		DungeonEventSpawner.generate(dung);
		dung.displayEnterablesValue();

	}

	private static void testFightSpawns() {
		CharacterFactory.spawnRandomParty();
	}
}
