package rpg.core.items.consumables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import rpg.core.items.Item;
import rpg.core.items.SpawnableItem;
import rpg.core.utils.CalcHelper;

public enum ConsumableType implements SpawnableItem {
	FOOD {
		@Override
		public Consumable getItemToSpawn() {
			return new Food();
		}

		@Override
		public int getDropRate() {
			return 50;
		}
	},

	KEY {
		@Override
		public Item getItemToSpawn() {
			return new Key();
		}

		@Override
		public int getDropRate() {
			return 40;
		}
	},

	BANDAGE {
		@Override
		public Item getItemToSpawn() {
			return new Bandage();
		}

		@Override
		public int getDropRate() {
			return 50;
		}
	},

	ANTI_VENOM {
		@Override
		public Item getItemToSpawn() {
			return new AntiVenom();
		}

		@Override
		public int getDropRate() {
			return 30;
		}
	},

	HOLY_WATER {
		@Override
		public Item getItemToSpawn() {
			return new HolyWater();
		}

		@Override
		public int getDropRate() {
			return 25;
		}
	},

	DARK_ESSENCE {
		@Override
		public Item getItemToSpawn() {
			return new DarkEssence();
		}

		@Override
		public int getDropRate() {
			return 25;
		}
	};

	public static List<Item> spawnConsumableStack() {
		Item item = chooseItemToSpawn();
		List<Item> consumables = new ArrayList<>();
		int randQuantity = CalcHelper.getRandomIntInRange(1, item.getMaxSpawnedQuantity())
				* item.getQuantityMultiplier();
		if (randQuantity > item.getMaxSpawnedQuantity()) {
			randQuantity = item.getMaxSpawnedQuantity();
		}
		for (int i = 0; i < randQuantity; i++) {
			consumables.add(item.getItem().getItemToSpawn());
		}
		return consumables;
	}

	private static Item chooseItemToSpawn() {
		int chance = CalcHelper.randInt(101);
		List<ConsumableType> consumTypes = Arrays.asList(values());
		int approximation = CalcHelper.calcApproxInt(chance,
				consumTypes.stream().map(e -> e.getDropRate()).collect(Collectors.toList()));
		int skip = CalcHelper.randInt((int) consumTypes.stream().filter(e -> e.getDropRate() == approximation).count()-1);
		return consumTypes.stream().filter(e -> e.getDropRate() == approximation).skip(skip).findFirst().get().getItemToSpawn();
	}

}
