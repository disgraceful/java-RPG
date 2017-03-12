package com.disgrace.ddripoff.items;

import java.util.Random;

public enum ItemType implements SpawnableItem {

	TRINKET {
		@Override
		public Item getItemToSpawn() {
			return TrinkeType.values()[new Random().nextInt(values().length)].getItemToSpawn();

		}
	};
	// }, TREASURE{
	//
	// }, CONSUMABLE{
	//
	// }, QUEST_ITEM{
	//
	// };

	enum TrinkeType implements SpawnableItem {
		TEST_TRINKET {
			@Override
			public Item getItemToSpawn() {
				return new TestTrinket();
			}
		};
	}
}
