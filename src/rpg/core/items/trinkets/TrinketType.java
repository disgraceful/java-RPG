package rpg.core.items.trinkets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import rpg.core.items.SpawnableItem;
import rpg.core.utils.CalcHelper;

public enum TrinketType implements SpawnableItem {
	TEST_TRINKET_COMMON {
		@Override
		public Trinket getItemToSpawn() {
			return new TestTrinketCommon();
		}

		@Override
		public int getDropRate() {
			// TODO Auto-generated method stub
			return 0;
		}
	},TEST_TRINKET_UNCOMMON {
		@Override
		public Trinket getItemToSpawn() {
			return new TestTrinketUncommon();
		}

		@Override
		public int getDropRate() {
			// TODO Auto-generated method stub
			return 0;
		}
	},TEST_TRINKET_RARE {
		@Override
		public Trinket getItemToSpawn() {
			return new TestTrinketRare();
		}

		@Override
		public int getDropRate() {
			// TODO Auto-generated method stub
			return 0;
		}
	},TEST_TRINKET_ABYSSMAL {
		@Override
		public Trinket getItemToSpawn() {
			return new TestTrinketAbyssmal();
		}

		@Override
		public int getDropRate() {
			// TODO Auto-generated method stub
			return 0;
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
	
	public static Trinket spawnTrinket() {
		int chance = CalcHelper.getRandomInt(101);
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