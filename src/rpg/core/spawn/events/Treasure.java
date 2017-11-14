package rpg.core.spawn.events;

import java.util.ArrayList;
import java.util.List;

import rpg.core.items.Item;
import rpg.core.spawn.ItemFactory;
import rpg.core.utils.CalcHelper;


public class Treasure extends SpawnEvent {
	private List<Item> loot = new ArrayList<>();

	public Treasure() {
		spawnType = SpawnableEventType.TREASURE;
		//loot = ItemFactory.spawnLoot(CalcHelper.getRandomIntInRange(1, 4));
	}

	@Override
	public void trigger() {
		if(!triggered){
			
		}
		//TODO open loot if yes add to DungSession Inventory
	}

}
