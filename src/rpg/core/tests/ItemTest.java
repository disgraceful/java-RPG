package rpg.core.tests;

import org.junit.Test;

import rpg.core.items.LootType;
import rpg.core.spawn.ItemFactory;

public class ItemTest {

	@Test
	public void testSpawnConsumables(){
		for (int i = 0; i < 10; i++) {
			ItemFactory.spawnLoot(LootType.SMALL_LOOT).getLootItems().forEach(e->System.out.println(e.getClass()));
			System.out.println("llllll");
		}
	}
}
