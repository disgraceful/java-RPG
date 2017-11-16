package rpg.core.items.treasure;

import java.util.Arrays;

import rpg.core.items.Item;
import rpg.core.items.ItemRarity;
import rpg.core.items.SpawnableItem;
import rpg.core.utils.StreamUtils;

public enum TreasureType implements SpawnableItem {
	GOLD {
		@Override
		public Treasure getItemToSpawn() {
			return new Gold();
		}
	},
	BATTLE_TROPHIES {
		@Override
		public Treasure getItemToSpawn() {
			return new BattleTrophies();
		}
	},
	CRYSTAL_GEMS {
		@Override
		public Treasure getItemToSpawn() {
			return new CrystalGems();
		}
	},
	ELDRITCH_RELICS {
		@Override
		public Treasure getItemToSpawn() {
			return new EldritchRelics();
		}
	};
	
	
	public static Item getTreasureByRarity(ItemRarity rarity) {
		return StreamUtils.getRandomItemFromStream(Arrays.asList(values())
				.stream()
				.filter(e -> e.getItemToSpawn().getRarity() == rarity))
				.getItemToSpawn();
	}
}
