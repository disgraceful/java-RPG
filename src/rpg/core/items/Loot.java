package rpg.core.items;

import java.util.ArrayList;
import java.util.List;

public class Loot {

	private List<Item> lootItems = new ArrayList<>();

	public Loot() {
	}

	public Loot(List<Item> lootItems) {
		this.lootItems = lootItems;
	}

	public List<Item> getLootItems() {
		return lootItems;
	}

	public void setLootItems(List<Item> lootItems) {
		this.lootItems = lootItems;
	}

	public void addItemToLoot(Item lootItem) {
		lootItems.add(lootItem);
	}

	public void addAllToLoot(List<Item> lootItems) {
		lootItems.addAll(lootItems);
	}

}
