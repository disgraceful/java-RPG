package rpg.core.spawn;

import java.util.ArrayList;
import java.util.List;

import rpg.core.items.Item;
import rpg.core.items.ItemDrop;
import rpg.core.items.Loot;
import rpg.core.items.LootType;
import rpg.core.items.SpawnableItem;
import rpg.core.items.consumables.ConsumableType;
import rpg.core.items.treasure.TreasureType;
import rpg.core.items.trinkets.TrinketType;
import rpg.core.utils.CalcHelper;

public class ItemFactory {

	private ItemFactory() {
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

	public static Loot spawnLoot(LootType lootType) {
		List<Item> resultList = new ArrayList<>();
		int currentGold = CalcHelper.calcRandomIntWithPercent(lootType.getGoldEqv(), 0.25);
		while (currentGold > 0) {
			int chanceToDecideSpecificItemType = CalcHelper.randInt(101);
			List<Item> items = spawnRandomItem(chanceToDecideSpecificItemType);
			for (Item item : items) {
				currentGold-=item.getCost();
			}
			resultList.addAll(items);
		}
		Loot loot = new Loot();
		loot.setLootItems(resultList);
		return loot;
	}

	private static List<Item> spawnRandomItem(int chance) {
		if (chance < ItemDrop.TRINKET_DROP.getDrop()) {
			return new ArrayList<Item>() {{TrinketType.spawnTrinket();}};
		} else if (chance < ItemDrop.CONSUMABLE_DROP.getDrop()) {
			return ConsumableType.spawnConsumableStack();
		} else {
			return new ArrayList<Item>(){{TreasureType.spawnTreasure(chance);}};
		}
	}

}
