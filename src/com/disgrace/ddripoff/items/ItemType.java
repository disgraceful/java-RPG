package com.disgrace.ddripoff.items;

public enum ItemType implements SpawnableItem {

	TEST_TRINKET_COMMON {
		@Override
		public Trinket getItemToSpawn() {
			return new TestTrinketCommon();
		}
	},TEST_TRINKET_UNCOMMON {
		@Override
		public Trinket getItemToSpawn() {
			return new TestTrinketUncommon();
		}
	},TEST_TRINKET_RARE {
		@Override
		public Trinket getItemToSpawn() {
			return new TestTrinketRare();
		}
	},TEST_TRINKET_ABYSSMAL {
		@Override
		public Trinket getItemToSpawn() {
			return new TestTrinketAbyssmal();
		}
	},GOLD{
		@Override
		public Treasure getItemToSpawn(){
			return new Gold();
		}
	};
}
