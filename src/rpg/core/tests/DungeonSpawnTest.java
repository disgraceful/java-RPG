package rpg.core.tests;

import org.junit.Before;
import org.junit.Test;

import rpg.core.dungeon.Desert;
import rpg.core.dungeon.DungeonBuilder;
import rpg.core.dungeon.DungeonSize;
import rpg.core.dungeon.events.DungeonEventSpawner;

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

}
