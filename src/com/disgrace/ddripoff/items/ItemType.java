package com.disgrace.ddripoff.items;

public enum ItemType implements SpawnableItem {

	TEST_TRINKET {
		@Override
		public Trinket getItemToSpawn() {
			return new TestTrinketCommon();
		}
	};
}
