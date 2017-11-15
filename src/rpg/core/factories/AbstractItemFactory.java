package rpg.core.factories;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import rpg.core.items.Item;
import rpg.core.items.ItemRarity;
import rpg.core.utils.CalcHelper;

public abstract class AbstractItemFactory {
	public abstract List<Item> createItems();

	public ItemRarity chooseRarity(int chance) {
		int item = CalcHelper.calcMinAfterSubstracte(chance,
				Arrays.asList(ItemRarity.values()).stream().map(e -> e.getDropRate()).collect(Collectors.toList()));
		return ItemRarity.getRarityByDropRate(item);

	}
}
