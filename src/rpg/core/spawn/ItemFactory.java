package rpg.core.spawn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import rpg.core.items.Item;
import rpg.core.items.ItemDrop;
import rpg.core.items.SpawnableItem;
import rpg.core.items.consumables.ConsumableType;
import rpg.core.items.treasure.TreasureType;
import rpg.core.items.trinkets.TrinketType;
import rpg.core.utils.CalcHelper;

public class ItemFactory {

	private ItemFactory() {
	}

	public static Item spawnItem() {
		return spawnRandomItem(CalcHelper.getRandomInt(101));
	}

	public static Item spawnConcreteItem(SpawnableItem concreteItem) {
		return concreteItem.getItemToSpawn();
	}

	public static List<Item> spawnItems(SpawnableItem concreteItem, int quantity) {
		List<Item> items = new ArrayList<>();
		for (int i = 0; i < quantity; i++) {
			items.add(concreteItem.getItemToSpawn());
		}
		return items;
	}

	public static List<Item> spawnLoot(int amount) {
		List<Item> resultList = new ArrayList<>();
		while (resultList.size() < amount) {
			int chanceToDecideSpecificItemType = CalcHelper.getRandomInt(101);
			resultList.add(spawnRandomItem(chanceToDecideSpecificItemType));
		}
		return resultList;
	}

	private static Item spawnRandomItem(int chance) {
		if (chance < ItemDrop.TRINKET_DROP.getDrop()) {
			return TrinketType.spawnTrinket();
		} else if (chance < ItemDrop.CONSUMABLE_DROP.getDrop()) {
			return ConsumableType.spawnConsumable();
		} else {
			return TreasureType.spawnTreasure(new Random().nextInt(101));
		}
	}

}
