package rpg.core.items.treasure;

import rpg.core.items.SpawnableItem;

public enum TreasureType implements SpawnableItem {
	GOLD {
		@Override
		public Treasure getItemToSpawn() {
			return new Gold();
		}
	},
	GEMS {
		@Override
		public Treasure getItemToSpawn() {
			return new Gems();
		}
	},
	SUPER_TREASURE {
		@Override
		public Treasure getItemToSpawn() {
			return new SuperTreasure();
		}
	};
}
