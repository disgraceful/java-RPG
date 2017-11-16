package rpg.core.factories;

import java.util.ArrayList;
import java.util.List;

import rpg.core.items.Item;
import rpg.core.items.ItemRarity;
import rpg.core.items.SpawnableItem;
import rpg.core.utils.CalcHelper;

public abstract class AbstractItemFactory {

	protected SpawnableItem itemToSpawn;
	
	public List<Item> createItems() {
		int chance = CalcHelper.randInt(101);
		ItemRarity rarity = ItemRarity.chooseRarity(chance);
		Item item = itemToSpawn.getItemByRarity(rarity);
		List<Item> consumables = new ArrayList<>();
		int randQuantity = CalcHelper.getRandomIntInRange(1, item.getMaxSpawnedQuantity()+1)
				* item.getQuantityMultiplier();
		if (randQuantity > item.getMaxSpawnedQuantity()) {
			randQuantity = item.getMaxSpawnedQuantity();
		}
		for (int i = 0; i < randQuantity; i++) {
			consumables.add(item.getItem().getItemToSpawn());
		}
		return consumables;
	}
}
