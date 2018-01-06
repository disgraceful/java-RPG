package rpg.core.factories;

import java.util.HashMap;
import java.util.Map;

import rpg.core.items.Item;
import rpg.core.items.ItemRarity;
import rpg.core.items.SpawnableItem;
import rpg.core.utils.CalcHelper;

public abstract class AbstractItemFactory {

	protected SpawnableItem itemToSpawn;
	
	public Map<SpawnableItem,Integer> createItems() {
		int chance = CalcHelper.randInt(101);
		ItemRarity rarity = ItemRarity.chooseRarity(chance);
		Item item = itemToSpawn.getItemByRarity(rarity);
		int randQuantity = CalcHelper.getRandomIntInRange(1, item.getMaxSpawnedQuantity()+1)
				* item.getQuantityMultiplier();
		if (randQuantity > item.getMaxSpawnedQuantity()) {
			randQuantity = item.getMaxSpawnedQuantity();
		}
	
		Map<SpawnableItem,Integer>spawned = new HashMap<>();
		spawned.put(item.getItem(), randQuantity);
		return spawned;
	}
}
