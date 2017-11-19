package rpg.core.factories;

import java.util.ArrayList;
import java.util.List;

import rpg.core.items.Item;
import rpg.core.items.Loot;
import rpg.core.items.LootType;
import rpg.core.utils.CalcHelper;

public class LootFactory {

	public static Loot spawnLoot(LootType lootType) {
		List<Item> resultList = new ArrayList<>();
		int currentGold = lootType.getGoldEqv();
		while (currentGold > 0) {
			int chanceToDecideItemType = CalcHelper.randInt(101);
			AbstractItemFactory factory = FactoryProvider.getFactory(chanceToDecideItemType);
			List<Item> items = factory.createItems();
			for (Item item : items) {
				currentGold -= item.getCost();
				if (currentGold <= 0) {
					resultList.add(item);
					break;
				}
				resultList.add(item);
			}
		}
		Loot loot = new Loot();
		loot.setLootItems(resultList);
		return loot;
	}
}
