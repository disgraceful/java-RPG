package rpg.core.factories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rpg.core.items.Item;
import rpg.core.items.ItemRarity;
import rpg.core.items.consumables.ConsumableType;
import rpg.core.utils.CalcHelper;

public class ConsumableFactory extends AbstractItemFactory{

	@Override
	public List<Item> createItems() {
		int chance = CalcHelper.randInt(101);
		//System.out.println(chance);
		ItemRarity rarity = ItemRarity.chooseRarity(chance);
		//System.out.println(rarity);
		Item item = ConsumableType.getConsumableByRarity(rarity);
		//System.out.println(item.getClass());
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
