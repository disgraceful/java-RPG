package com.disgrace.ddripoff.spawn;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.items.Item;
import com.disgrace.ddripoff.utils.CalculationHelper;

@XmlRootElement
public class Treasure extends SpawnEvent {
	private Set<Item> loot = new HashSet<>();

	public Treasure() {
		spawnType = SpawnableEventType.TREASURE;
		loot = new HashSet<>(ItemFactory.spawnLoot(CalculationHelper.getRandomIntInRange(1, 4)));
	}

	@Override
	public void trigger() {
		if(!triggered){
			
		}
		//TODO open loot if yes add to DungSession Inventory
	}

}
