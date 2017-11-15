package rpg.core.items;

import java.util.Arrays;
import java.util.stream.Collectors;

import rpg.core.utils.CalcHelper;

public enum ItemRarity {
	COMMON(55), UNCOMMON(25), RARE(15), EPIC(5);

	private int dropRate;

	private ItemRarity(int drop) {
		dropRate = drop;
	}

	public int getDropRate() {
		return dropRate;
		
	}

	public static ItemRarity getRarityByDropRate(int chance) {
		return Arrays.asList(values()).stream().filter(e -> e.dropRate == chance).findFirst().get();
	}

	public static ItemRarity chooseRarity(int chance) {
		int item = CalcHelper.calcIndexBeforeSelected(chance,
				Arrays.asList(values()).stream().map(e -> e.getDropRate()).collect(Collectors.toList()));
		return getRarityByDropRate(item);

	}
}
