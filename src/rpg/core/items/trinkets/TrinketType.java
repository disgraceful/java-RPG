package rpg.core.items.trinkets;

import java.util.Arrays;

import rpg.core.items.Item;
import rpg.core.items.ItemRarity;
import rpg.core.items.SpawnableItem;
import rpg.core.utils.StreamUtils;

public enum TrinketType implements SpawnableItem {
	HONORABLE_VITIS {
		@Override
		public Item getItemToSpawn() {
			return new HonorableVitis();
		}
	},
	ETCHED_SHIELD {
		@Override
		public Item getItemToSpawn() {
			return new EtchedShield();
		}
	},
	WREATH_OF_CENTURION {
		@Override
		public Item getItemToSpawn() {
			return new WreathOfCenturion();
		}
	},
	RUNE_SHIELD {
		@Override
		public Item getItemToSpawn() {
			return new RuneShield();
		}
	},
	STOUT_SHIELD {
		@Override
		public Item getItemToSpawn() {
			return new StoutShield();
		}
	};

	@Override
	public Item getItemByRarity(ItemRarity rarity) {
		return StreamUtils
				.getRandomItemFromStream(
						Arrays.asList(values()).stream().filter(e -> e.getItemToSpawn().getRarity() == rarity))
				.getItemToSpawn();
	}

}