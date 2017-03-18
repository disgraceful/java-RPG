package com.disgrace.ddripoff.spawn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.disgrace.ddripoff.items.Item;
import com.disgrace.ddripoff.items.ItemDrop;
import com.disgrace.ddripoff.items.TrinketRarity;
import com.disgrace.ddripoff.items.TrinketType;

public class ItemFactory {

	public static Item spawnItem() {
		int chance = new Random().nextInt(101);

	}

	public static List<Item> spawnLoot(int amount) {
		return new ArrayList<>(amount);
	}

	private Item spwnRandomItem(int chance) {
		if (chance < ItemDrop.TRINKET_DROP.getDrop()) {
			return TrinketType.spawnTrinket(new Random().nextInt(101));
		} else if (chance < ItemDrop.CONSUMABLE_DROP.getDrop()) {

		} else if (chance < ItemDrop.TRINKET_DROP.getDrop()) {

		} else {
			// return empty;
		}
	}

	}
