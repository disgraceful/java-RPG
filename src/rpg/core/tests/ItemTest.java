package rpg.core.tests;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import rpg.core.factories.AbstractItemFactory;
import rpg.core.factories.FactoryProvider;
import rpg.core.factories.LootFactory;
import rpg.core.items.LootType;

public class ItemTest {

	
	public void testSpawnConsumables() {
		AbstractItemFactory factory = FactoryProvider.getFactory(20);
		for (int i = 0; i < 100; i++) {
			Map<Class, Long>occurances = calcualteExactNumbers(factory.createItems());
			occurances.forEach((k,v)->System.out.println(v + "x "+k.getSimpleName()));
		}
	}
	
	@Test
	public void testLootSpawn() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Loot #"+ i);
			Map<Class, Long>occurances = calcualteExactNumbers(LootFactory.spawnLoot(LootType.SMALL_LOOT).getLootItems());
			occurances.forEach((k,v)->System.out.println(v + "x "+k.getSimpleName()));
		}
	}

	private <T> Map<Class,Long> calcualteExactNumbers(List<T> items) {
		return items.stream().collect(Collectors.groupingBy(e -> e.getClass(), Collectors.counting()));
	}
}
