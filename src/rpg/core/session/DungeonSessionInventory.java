package rpg.core.session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import rpg.core.items.Item;
import rpg.core.items.Loot;

public class DungeonSessionInventory {
	private List<Item> inventory = new ArrayList<>();
	private Map<Item, Integer> inventortMap = new HashMap<>();
	private int inventoryCap = 20;

	public void addItem(Item item) {
		inventory.add(item);
	}

	public void addItems(List<Item> items) {
		inventory.addAll(items);
	}

	public void addLoot(Loot loot) {
		inventory.addAll(loot.getLootItems());
	}

	public void orderInventory() {
		Map<Item, Integer> counts = new HashMap<>();
		for (Item item : inventory) {
			if (!counts.keySet().contains(item.getItem())) {
				counts.put(item, Collections.frequency(inventory, item.getClass()));
			}
		}

		for (Entry<Item, Integer> item : counts.entrySet()) {
			int totalItemQuantity = item.getValue();
			while (totalItemQuantity > item.getKey().getStackQuantity()) {
				inventortMap.put(item.getKey(), item.getKey().getStackQuantity());
				totalItemQuantity -= item.getKey().getStackQuantity();
			}
			inventortMap.put(item.getKey(), totalItemQuantity);
		}

	}

}
