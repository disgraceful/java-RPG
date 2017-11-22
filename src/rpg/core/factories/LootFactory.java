package rpg.core.factories;

import java.util.ArrayList;
import java.util.List;

import rpg.core.items.Item;
import rpg.core.items.Loot;
import rpg.core.items.LootType;
import rpg.core.items.SpawnableItem;
import rpg.core.utils.CalcHelper;

public class LootFactory {

	public static Loot spawnLoot(LootType lootType) {
		List<Item> resultList = new ArrayList<>();
		int currentGold = lootType.getGoldEqv();
		while (currentGold > 0) {
			int chanceToDecideItemType = CalcHelper.randInt(101);
			AbstractItemFactory factory = FactoryProvider.getItemFactory(chanceToDecideItemType);
			List<Item> items = factory.createItems();
			for (Item item : items) {
				currentGold -= item.getCost();
				if (currentGold <= 0) {
					resultList.add(item);
					break;
				}
				resultList.add(item);
			}
		}
		Loot loot = new Loot();
		loot.setLootItems(resultList);
		return loot;
	}

	public static Loot spawnSpecificLoot(SpawnableItem item, int quantity) {
		List<Item> resultList = new ArrayList<>();
		for (int i = 0; i < quantity; i++) {
			resultList.add(item.getItemToSpawn());
		}
		Loot loot = new Loot();
		loot.setLootItems(resultList);
		return loot;
	}
}
