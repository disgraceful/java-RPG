package com.disgrace.ddripoff.items;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum TreasureType implements SpawnableItem {
	GOLD {
		@Override
		public Treasure getItemToSpawn() {
			return new Gold();
		}
	},
	JEWELS {
		@Override
		public Treasure getItemToSpawn() {
			return new Jewels();
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
		}else if(chance<JEWELS.getItemToSpawn().getDropRate()){
			return (Treasure) JEWELS.getItemToSpawn();
		}else{
			return (Treasure)GOLD.getItemToSpawn();
		}
	}
}
