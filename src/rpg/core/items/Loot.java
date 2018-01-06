package rpg.core.items;

import java.util.ArrayList;
import java.util.List;

public class Loot {
	
	public static final Loot EMPTY_LOOT = new Loot();
	private List<Item> lootItems;

	public Loot() {
		lootItems = new ArrayList<>();
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
