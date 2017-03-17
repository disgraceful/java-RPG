package com.disgrace.ddripoff.items;

public enum TrinketRarity {
	COMMON(60,750), UNCOMMON(25,1000), RARE(13,2000), ABYSMAL(2,5000);
	 private final int dropRate;
	 private final int cost;

	 private TrinketRarity(int dropRate,int cost){
		 this.dropRate = dropRate;
		 this.cost = cost;
	 }
	 
	public int getDropRate() {
		return dropRate;
	}
	
	public int getCost() {
		return cost;
	}
	
	public static TrinketRarity getRandomRarityItem(int randomChance){
		if(randomChance<TrinketRarity.ABYSMAL.getDropRate()){
			return TrinketRarity.ABYSMAL;
		}else if(randomChance<TrinketRarity.RARE.getDropRate()){
			return TrinketRarity.RARE;
		}else if(randomChance<TrinketRarity.UNCOMMON.getDropRate()){
			return TrinketRarity.UNCOMMON;
		}else if(randomChance<TrinketRarity.COMMON.getDropRate()){
			return TrinketRarity.COMMON;
		}else{
			return null;
		}
	}
}


