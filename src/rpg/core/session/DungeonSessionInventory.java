package rpg.core.session;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import rpg.core.items.Loot;
import rpg.core.items.SpawnableItem;

public class DungeonSessionInventory {
	private Map<SpawnableItem, Integer> uniqueItemTypesMap = new HashMap<>();
	private Map<Integer, Map<SpawnableItem, Integer>> inventorySlots = new HashMap<>();
	private int inventoryCap = 5;
	private int currentCap = 0;

	public Loot addLoot(Loot loot) {
		for (Entry<SpawnableItem, Integer> set : loot.getLootItems().entrySet()) {
			int occurance = set.getValue();
			int avaliableSpace = getAvaliableSpaceForItem(set.getKey());
			if (occurance <= avaliableSpace) {
				uniqueItemTypesMap.merge(set.getKey(), occurance, Integer::sum);
			} else {
				uniqueItemTypesMap.merge(set.getKey(), avaliableSpace, Integer::sum);
				loot.getLootItems().replace(set.getKey(), occurance - avaliableSpace);
			}
			orderInventory();
			currentCap=inventorySlots.entrySet().size();
		}
		return loot;
	}

	private void orderInventory() {
		int counter = 0;
		for (Entry<SpawnableItem, Integer> item : uniqueItemTypesMap.entrySet()) {
			int totalItemQuantity = item.getValue();
			Map<SpawnableItem, Integer> currentSlot;
			while (totalItemQuantity > item.getKey().getItemToSpawn().getStackQuantity()) {
				currentSlot = new HashMap<>();
				currentSlot.put(item.getKey(), item.getKey().getItemToSpawn().getStackQuantity());
				inventorySlots.put(counter, currentSlot);
				counter++;
				totalItemQuantity -= item.getKey().getItemToSpawn().getStackQuantity();
			}
			currentSlot = new HashMap<>();
			currentSlot.put(item.getKey(), totalItemQuantity);
			inventorySlots.put(counter, currentSlot);
			counter++;
		}
	}

	private int getAvaliableSpaceForItem(SpawnableItem item) {
		int stackQuantity = item.getItemToSpawn().getStackQuantity();
		int currentValue = uniqueItemTypesMap.containsKey(item) ? uniqueItemTypesMap.get(item) : 0;
		int occurances = 0;
		for (Entry<Integer, Map<SpawnableItem, Integer>> set : inventorySlots.entrySet()) {
			for (Entry<SpawnableItem, Integer> entry : set.getValue().entrySet()) {
				if (entry.getKey().equals(item)) {
					occurances++;
				}
			}
		}

		int avaliableSpace = stackQuantity * occurances - currentValue;
		avaliableSpace += stackQuantity * (inventoryCap - currentCap);
		return avaliableSpace;
	}

	public void displayInventory() {
		System.out.println("inventory: " + currentCap + "/" + inventoryCap);
		for (Entry<Integer, Map<SpawnableItem, Integer>> set : inventorySlots.entrySet()) {
			for (Entry<SpawnableItem, Integer> entry : set.getValue().entrySet()) {
				System.out.println(entry.getKey().getItemToSpawn().getName() + " x" + entry.getValue());
			}
		}
	}

	public boolean inventoryFull() {
		return currentCap >= inventoryCap;
	}

	private int getSlotsOccupiedByItem(SpawnableItem item) {
		int value = uniqueItemTypesMap.get(item);
		int stackQuantity = item.getItemToSpawn().getStackQuantity();
		double left = value / stackQuantity;
		if (left < 1) {
			return 1;
		} else if (value % stackQuantity != 0) {
			return (int) left + 1;
		} else {
			return (int) left;
		}

	}

}
