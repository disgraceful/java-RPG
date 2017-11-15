package rpg.core.tests;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import rpg.core.factories.AbstractItemFactory;
import rpg.core.factories.ConsumableFactory;

public class ItemTest {

	@Test
	public void testSpawnConsumables() {
		AbstractItemFactory factory = new ConsumableFactory();
		for (int i = 0; i < 100; i++) {
			Map<Class, Long>occurances = calcualteExactNumbers(factory.createItems());
			occurances.forEach((k,v)->System.out.println(v + "x "+k.getSimpleName()));
		}
	}

	private <T> Map<Class,Long> calcualteExactNumbers(List<T> items) {
		return items.stream().collect(Collectors.groupingBy(e -> e.getClass(), Collectors.counting()));
	}
}
