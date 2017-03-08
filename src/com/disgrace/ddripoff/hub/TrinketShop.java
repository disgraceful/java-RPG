package com.disgrace.ddripoff.hub;

import java.util.ArrayList;
import java.util.List;

import com.disgrace.ddripoff.items.Trinket;

public class TrinketShop {
	List<Trinket> itemsForSale = new ArrayList<>();

	private static final int ITEM_SPAWN_LIMIT = 5;

	public List<Trinket> getItemsForSale() {
		return itemsForSale;
	}

	public void buy(Trinket item) {
		if (!itemsForSale.contains(item)) {
			return;
		}
		// TODO actually add to player's hero roster
		itemsForSale.remove(item);
	}

	public void spawnVenturers() {
		itemsForSale.clear();
		for (int i = 0; i < ITEM_SPAWN_LIMIT; i++) {
			//TODO implement trinket spawning;
		}
	}
}
