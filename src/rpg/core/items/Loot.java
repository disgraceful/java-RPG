package rpg.core.items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Loot {

	public static final Loot EMPTY_LOOT = new Loot();
	private Map<SpawnableItem, Integer> lootItems;

	public Loot() {
		lootItems = new HashMap<>();
	}

	public Loot(Map<SpawnableItem, Integer> lootItems) {
		this.lootItems = lootItems;
	}

	public Map<SpawnableItem, Integer> getLootItems() {
		return lootItems;
	}

	public void setLootItems(Map<SpawnableItem, Integer> lootItems) {
		this.lootItems = lootItems;
	}

//	public void addItemToLoot(Item lootItem) {
//		lootItems.add(lootItem);
//	}
//
//	public void addAllToLoot(List<Item> lootItems) {
//		lootItems.addAll(lootItems);
//	}

}
