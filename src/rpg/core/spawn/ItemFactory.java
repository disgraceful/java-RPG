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

	



	

}
