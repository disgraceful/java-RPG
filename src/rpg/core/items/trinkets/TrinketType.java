package rpg.core.items.trinkets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import rpg.core.items.Item;
import rpg.core.items.SpawnableItem;
import rpg.core.utils.CalcHelper;

public enum TrinketType implements SpawnableItem {

	TEST;

	public static Trinket getRandItemByRarity(TrinketRarity rarity) {
		List<Trinket> resultList = new ArrayList<>();
		List<TrinketType> list = Arrays.asList(values());
		Collections.shuffle(list);
		for (TrinketType trinketType : list) {
			Trinket trinket = (Trinket) trinketType.getItemToSpawn();

			resultList.add(trinket);

		}
		return resultList.stream().findAny().get();
	}

	public static Trinket spawnTrinket() {
		int chance = CalcHelper.randInt(101);
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

	@Override
	public Item getItemToSpawn() {
		// TODO Auto-generated method stub
		return null;
	}

}