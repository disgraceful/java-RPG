package rpg.core.spawn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import rpg.core.items.Item;
import rpg.core.items.ItemType;
import rpg.core.items.Loot;
import rpg.core.items.LootType;
import rpg.core.items.SpawnableItem;
import rpg.core.items.consumables.ConsumableType;
import rpg.core.items.treasure.TreasureType;
import rpg.core.items.trinkets.TrinketType;
import rpg.core.utils.CalcHelper;

public class ItemFactory {

	private ItemFactory() {
	}

	public static Item spawnConcreteItem(SpawnableItem concreteItem) {
		return concreteItem.getItemToSpawn();
	}

	public static List<Item> spawnItems(SpawnableItem concreteItem, int quantity) {
		List<Item> items = new ArrayList<>();
		for (int i = 0; i < quantity; i++) {
			items.add(concreteItem.getItemToSpawn());
		}
		return items;
	}

	public static Loot spawnLoot(LootType lootType) {
		List<Item> resultList = new ArrayList<>();
		int currentGold = CalcHelper.calcRandomIntWithPercent(lootType.getGoldEqv(), 0.25);
		while (currentGold > 0) {
			int chanceToDecideSpecificItemType = CalcHelper.randInt(101);
			List<Item> items = spawnRandomItem(chanceToDecideSpecificItemType);
			for (Item item : items) {
				currentGold -= item.getCost();
			}
			resultList.addAll(items);
		}
		Loot loot = new Loot();
		loot.setLootItems(resultList);
		return loot;
	}

	private static List<Item> spawnRandomItem(int chance) {
		int approx = CalcHelper.calcApproxInt(chance,
				Arrays.asList(ItemType.values()).stream().map(e -> e.getDrop()).collect(Collectors.toList()));

		return Collections.EMPTY_LIST;

	}

}
