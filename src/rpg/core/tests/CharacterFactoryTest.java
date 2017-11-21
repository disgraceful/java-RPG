package rpg.core.tests;

import org.junit.Test;

import rpg.core.dungeon.events.fight.WeakFight;

public class CharacterFactoryTest {

	@Test
	public void testSpawns(){
		WeakFight f = new WeakFight();
		f.spawn();
		
	}
}
