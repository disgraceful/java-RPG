package rpg.core.spawn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import rpg.core.items.ConsumableType;
import rpg.core.items.Item;
import rpg.core.items.ItemDrop;
import rpg.core.items.SpawnableItem;
import rpg.core.items.TreasureType;
import rpg.core.items.TrinketType;


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
			//System.out.println("chanceToDecideSpecificItemType: " + chanceToDecideSpecificItemType);
			resultList.add(spawnRandomItem(chanceToDecideSpecificItemType));
		}
		return resultList;
	}

	private static Item spawnRandomItem(int chance) {
		if (chance < ItemDrop.TRINKET_DROP.getDrop()) {
			int chanceToDecideConcreteItem = new Random().nextInt(101);
			//System.out.println("chanceToDecideConcreteItem: " + chanceToDecideConcreteItem);
			return TrinketType.spawnTrinket(chanceToDecideConcreteItem);
		} else if (chance < ItemDrop.CONSUMABLE_DROP.getDrop()) {
			return ConsumableType.spawnConsumable();
		} else {
			return TreasureType.spawnTreasure(new Random().nextInt(101));
		}
	}

}
