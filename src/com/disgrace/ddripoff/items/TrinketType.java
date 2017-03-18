package com.disgrace.ddripoff.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum TrinketType implements SpawnableItem {
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
	};
	
	public static Trinket getRandItemByRarity(TrinketRarity rarity){
		List<Trinket> resultList = new ArrayList<>();
		List<TrinketType> list  =Arrays.asList(values()); 
		Collections.shuffle(list);
		for (TrinketType trinketType : list) {
			Trinket trinket = (Trinket)trinketType.getItemToSpawn();
			if(trinket.getRarity()==rarity){
				resultList.add(trinket);
			}
		}
		return resultList.stream().findAny().get();
	}
	
	public static Trinket spawnTrinket(int chance) {
		if (chance < TrinketRarity.ABYSMAL.getDropRate()) {
			return TrinketType.getRandItemByRarity(TrinketRarity.ABYSMAL);
		} else if (chance < TrinketRarity.RARE.getDropRate()) {
			return TrinketType.getRandItemByRarity(TrinketRarity.RARE);
		} else if (chance < TrinketRarity.UNCOMMON.getDropRate()) {
			return TrinketType.getRandItemByRarity(TrinketRarity.UNCOMMON);
		} else {
			return TrinketType.getRandItemByRarity(TrinketRarity.COMMON);
		}
	}

} 	