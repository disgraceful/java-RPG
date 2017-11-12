package rpg.core.hub;

import java.util.ArrayList;
import java.util.List;

import rpg.core.items.trinkets.Trinket;
import rpg.core.session.GameSession;
import rpg.core.spawn.ItemFactory;


public class TrinketShop {
	private List<Trinket> itemsForSale = new ArrayList<>();
	private int itemSpawnLimit = 5;

	public List<Trinket> getItemsForSale() {
		return itemsForSale;
	}

	public int getItemSpawnLimit() {
		return itemSpawnLimit;
	}

	public void setItemSpawnLimit(int itemSpawnLimit) {
		this.itemSpawnLimit = itemSpawnLimit;
	}

	public void setItemsForSale(List<Trinket> itemsForSale) {
		this.itemsForSale = itemsForSale;
	}

	public void buy(Trinket item) {
		if (!itemsForSale.contains(item)) {
			return;
		}
		if (GameSession.getSessionInstance().getGold() < item.getCost()) {
			System.out.println("Not Enough Gold!");
		} else {
			GameSession.getSessionInstance().addItem(item);
			GameSession.getSessionInstance().addGold(-item.getCost());
			GameSession.getSessionInstance().addItem(item);
			itemsForSale.remove(item);
		}
	}

	public void spawnItems() {
		itemsForSale.clear();
		ItemFactory.spawnLoot(itemSpawnLimit);
	}
}
