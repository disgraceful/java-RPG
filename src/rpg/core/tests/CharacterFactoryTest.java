package rpg.core.tests;

import rpg.core.spawn.events.WeakFight;
import org.junit.Test;

public class CharacterFactoryTest {

	@Test
	public void testSpawns(){
		WeakFight f = new WeakFight();
		f.spawn();
		
	}
}
