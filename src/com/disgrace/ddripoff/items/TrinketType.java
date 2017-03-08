package com.disgrace.ddripoff.items;

public enum TrinketType implements SpawnableItem {
	TEST_TRINKET {
		@Override
		public Trinket getItemToSpawn() {
			return new TestTrinket();
		}
	};

}
