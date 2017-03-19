package com.disgrace.ddripoff.spawn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.disgrace.ddripoff.items.ConsumableType;
import com.disgrace.ddripoff.items.Item;
import com.disgrace.ddripoff.items.ItemDrop;
import com.disgrace.ddripoff.items.SpawnableItem;
import com.disgrace.ddripoff.items.TreasureType;
import com.disgrace.ddripoff.items.TrinketType;

public class ItemFactory {

	private ItemFactory() {
	}

	public static Item spawnItem() {
		return spawnRandomItem(new Random().nextInt(101));
	}
	
	public static Item spawnConcreteItem(SpawnableItem concreteItem){
		return concreteItem.getItemToSpawn();
	}

	public static List<Item> spawnLoot(int amount) {
		List<Item> resultList = new ArrayList<>();
		while (resultList.size() < amount) {
			int chanceToDecideSpecificItemType = new Random().nextInt(20);
			System.out.println("chanceToDecideSpecificItemType: " + chanceToDecideSpecificItemType);
			resultList.add(spawnRandomItem(chanceToDecideSpecificItemType));
		}
		return resultList;
	}

	private static Item spawnRandomItem(int chance) {
		if (chance < ItemDrop.TRINKET_DROP.getDrop()) {
			int chanceToDecideConcreteItem = new Random().nextInt(101);
			System.out.println("chanceToDecideConcreteItem: " + chanceToDecideConcreteItem);
			return TrinketType.spawnTrinket(chanceToDecideConcreteItem);
		} else if (chance < ItemDrop.CONSUMABLE_DROP.getDrop()) {
			return ConsumableType.spawnConsumable();
		} else {
			return TreasureType.spawnTreasure(new Random().nextInt(101));
		}
	}

}
