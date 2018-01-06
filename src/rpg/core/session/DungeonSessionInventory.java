package rpg.core.session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import rpg.core.items.Item;
import rpg.core.items.Loot;
import rpg.core.items.SpawnableItem;

public class DungeonSessionInventory {
	private List<Item> inventory = new ArrayList<>();
	private Map<Item, Integer> inventoryMap = new HashMap<>();
	private Map<SpawnableItem, Integer> uniqueItemTypesMap = new HashMap<>();
	private int inventoryCap = 5;
	private int currentCap = 0;

	public void addLoot(Loot loot) {
		inventory.addAll(loot.getLootItems());
		orderInventory();
	}

	public void orderInventory() {
		List<SpawnableItem> spawnableItemList = inventory.stream().map(e -> e.getItem()).collect(Collectors.toList());
		for (SpawnableItem item : spawnableItemList) {
			if (!uniqueItemTypesMap.keySet().contains(item)) {
				uniqueItemTypesMap.put(item, Collections.frequency(spawnableItemList, item));
			}
		}

		for (Entry<SpawnableItem, Integer> item : uniqueItemTypesMap.entrySet()) {
			int totalItemQuantity = item.getValue();
			while (totalItemQuantity > item.getKey().getItemToSpawn().getStackQuantity()) {
				inventoryMap.put(item.getKey().getItemToSpawn(), item.getKey().getItemToSpawn().getStackQuantity());
				totalItemQuantity -= item.getKey().getItemToSpawn().getStackQuantity();
				currentCap++;
			}
			inventoryMap.put(item.getKey().getItemToSpawn(), totalItemQuantity);
			currentCap++;
		}
	}

	private int getAvaliableSpaceForItem(Item item) {
		int stackQuantity = item.getStackQuantity();
		int currentValue = uniqueItemTypesMap.get(item.getItem());
		int occurances = 0;
		for (Entry<Item, Integer> set : inventoryMap.entrySet()) {
			if (set.getKey().getItem().equals(item.getItem())) {
				occurances++;
			}
		}
		return 0;

	}

	public void displayInventory() {
		System.out.println("inventory: " + currentCap + "/" + inventoryCap);
		for (Entry<Item, Integer> item : inventoryMap.entrySet()) {
			System.out.println(item.getKey().getName() + " x" + item.getValue());
		}
	}

	public boolean inventoryFull() {
		return currentCap >= inventoryCap;
	}

}
