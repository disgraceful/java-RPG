package com.disgrace.ddripoff.spawn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.disgrace.ddripoff.items.Item;
import com.disgrace.ddripoff.items.ItemDrop;
import com.disgrace.ddripoff.items.TreasureType;
import com.disgrace.ddripoff.items.TrinketType;

public class ItemFactory {

	public static Item spawnItem() {
		return spawnRandomItem(new Random().nextInt(101));
	}

	public static List<Item> spawnLoot(int amount) {
		return new ArrayList<>(amount);
	}

	private static Item spawnRandomItem(int chance) {
		if (chance < ItemDrop.TRINKET_DROP.getDrop()) {
			return TrinketType.spawnTrinket(new Random().nextInt(101));
		} else if (chance < ItemDrop.CONSUMABLE_DROP.getDrop()) {
			return TreasureType.spawnTreasure(new Random().nextInt(101));
		} else {
				 
			}
		}

	}
