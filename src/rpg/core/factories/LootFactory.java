package rpg.core.factories;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import rpg.core.items.Loot;
import rpg.core.items.LootType;
import rpg.core.items.SpawnableItem;
import rpg.core.utils.CalcHelper;

public class LootFactory {

	public static Loot spawnLoot(LootType lootType) {
		Map<SpawnableItem, Integer> resultLoot = new HashMap<>();
		int currentGold = lootType.getGoldEqv();
		while (currentGold > 0) {
			int chanceToDecideItemType = CalcHelper.randInt(101);
			AbstractItemFactory factory = FactoryProvider.getItemFactory(chanceToDecideItemType);
			Map<SpawnableItem, Integer> items = factory.createItems();
			for (Entry<SpawnableItem, Integer> set : items.entrySet()) {
				for (int i = 0; i < set.getValue(); i++) {
					currentGold -= set.getKey().getItemToSpawn().getCost();
					if (currentGold <= 0) {
						items.replace(set.getKey(), i);
						break;
					}
				}
			}
			resultLoot.putAll(items);
		}
		return new Loot(resultLoot);
	}

	public static Loot spawnSpecificLoot(int[] quantity, SpawnableItem... items) {
		Map<SpawnableItem, Integer> resultLoot = new HashMap<>();
		for (int i = 0; i < items.length; i++) {
			resultLoot.putAll(spawnSpecificLoot(quantity[i], items[i]).getLootItems());
		}
		return new Loot(resultLoot);
	}

	public static Loot spawnSpecificLoot(int quantity, SpawnableItem item) {
		Map<SpawnableItem, Integer> resultLoot = new HashMap<>();
		resultLoot.put(item, quantity);
		return new Loot(resultLoot);
	}

}
