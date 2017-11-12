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
	
	public static Treasure spawnTreasure(int chance){
		if(chance<SUPER_TREASURE.getItemToSpawn().getDropRate()){
			return (Treasure) SUPER_TREASURE.getItemToSpawn();
		}else if(chance<GEMS.getItemToSpawn().getDropRate()){
			return (Treasure) GEMS.getItemToSpawn();
		}else{
			return (Treasure)GOLD.getItemToSpawn();
		}
	}
}
