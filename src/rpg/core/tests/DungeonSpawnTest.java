package rpg.core.tests;

import rpg.core.dungeon.Desert;
import rpg.core.dungeon.DungeonBuilder;
import rpg.core.dungeon.DungeonEventSpawner;
import rpg.core.dungeon.DungeonSize;
import rpg.core.spawn.CharacterFactory;

import org.junit.Before;
import org.junit.Test;


public class DungeonSpawnTest {
	static Desert dung = new Desert(DungeonSize.SMALL);
	
	@Before
	public void init(){
		DungeonBuilder.build(dung);
	}
	
	@Test
	public void testEventSpawner() {
		DungeonEventSpawner.generate(dung);
		dung.displayEnterablesValue();
	}

	private static void testFightSpawns() {
		CharacterFactory.spawnRandomParty();
	}
}
