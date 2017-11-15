package rpg.core.items.consumables;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import rpg.core.items.Item;
import rpg.core.items.ItemRarity;
import rpg.core.items.SpawnableItem;
import rpg.core.utils.CalcHelper;

public enum ConsumableType implements SpawnableItem {
	FOOD {
		@Override
		public Consumable getItemToSpawn() {
			return new Food();
		}
	},

	KEY {
		@Override
		public Item getItemToSpawn() {
			return new Key();
		}
	},

	BANDAGE {
		@Override
		public Item getItemToSpawn() {
			return new Bandage();
		}
	},

	ANTI_VENOM {
		@Override
		public Item getItemToSpawn() {
			return new AntiVenom();
		}
	},

	CLEANSING_BREW {
		@Override
		public Item getItemToSpawn() {
			return new CleansingBrew();
		}
	},

	HOLY_WATER {
		@Override
		public Item getItemToSpawn() {
			return new HolyWater();
		}
	},

	DARK_ESSENCE {
		@Override
		public Item getItemToSpawn() {
			return new DarkEssence();
		}
	};

	public static Item getConsumableByRarity(ItemRarity rarity) {
		if (rarity == ItemRarity.EPIC) {
			return values()[CalcHelper.randInt(values().length)].getItemToSpawn();
		}
		return Arrays.asList(values()).stream()
				.filter(e -> e.getItemToSpawn().getRarity() == rarity)
				.collect(Collectors.collectingAndThen(Collectors.toList(), collected-> {
					Collections.shuffle(collected);
					return collected.stream();
				}))
				.findAny()
				.get()
				.getItemToSpawn();
	}

}
