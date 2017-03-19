package com.disgrace.ddripoff.spawn;

import java.util.HashSet;
import java.util.Set;

import com.disgrace.ddripoff.items.Item;
import com.disgrace.ddripoff.utils.CalculationHelper;

public class Treasure extends SpawnEvent {
	private Set<Item> loot = new HashSet<>();

	public Treasure() {
		spawnType = SpawnableEventType.TREASURE;
	}

	@Override
	public void trigger() {
		loot = new HashSet<>(ItemFactory.spawnLoot(CalculationHelper.getRandomIntInRange(1, 4)));
		//TODO Session inventory. 
	}

}
