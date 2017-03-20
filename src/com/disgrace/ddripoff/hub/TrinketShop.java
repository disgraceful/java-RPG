package com.disgrace.ddripoff.hub;

import java.util.ArrayList;
import java.util.List;

import com.disgrace.ddripoff.items.Trinket;
import com.disgrace.ddripoff.session.GameSession;
import com.disgrace.ddripoff.spawn.ItemFactory;

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
		if (GameSession.getSession().getGold() < item.getCost()) {
			System.out.println("Not Enough Gold!");
		} else {
			GameSession.getSession().addItem(item);
			GameSession.getSession().addGold(-item.getCost());
			GameSession.getSession().addItem(item);
			itemsForSale.remove(item);
		}
	}

	public void spawnItems() {
		itemsForSale.clear();
		ItemFactory.spawnLoot(ITEM_SPAWN_LIMIT);
	}
}
