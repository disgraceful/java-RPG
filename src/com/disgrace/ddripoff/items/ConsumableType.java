package com.disgrace.ddripoff.items;

import java.util.Random;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum ConsumableType implements SpawnableItem {
	FOOD {
		@Override
		public Consumable getItemToSpawn() {
			return new Food();
		}
	};

	public static Consumable spawnConsumable() {
		return (Consumable) values()[new Random().nextInt(values().length)].getItemToSpawn();
	}

}
