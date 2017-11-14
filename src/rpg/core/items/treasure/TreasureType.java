package rpg.core.items.treasure;

import rpg.core.items.SpawnableItem;

public enum TreasureType implements SpawnableItem {
	GOLD {
		@Override
		public Treasure getItemToSpawn() {
			return new Gold();
		}

		@Override
		public int getDropRate() {
			// TODO Auto-generated method stub
			return 0;
		}
	},
	GEMS {
		@Override
		public Treasure getItemToSpawn() {
			return new Gems();
		}

		@Override
		public int getDropRate() {
			// TODO Auto-generated method stub
			return 0;
		}
	},
	SUPER_TREASURE {
		@Override
		public Treasure getItemToSpawn() {
			return new SuperTreasure();
		}

		@Override
		public int getDropRate() {
			// TODO Auto-generated method stub
			return 0;
		}
	};

	public static Treasure spawnTreasure(int chance) {
		if (chance < SUPER_TREASURE.getDropRate()) {
			return (Treasure) SUPER_TREASURE.getItemToSpawn();
		} else if (chance < GEMS.getDropRate()) {
			return (Treasure) GEMS.getItemToSpawn();
		} else {
			return (Treasure) GOLD.getItemToSpawn();
		}
	}
}
