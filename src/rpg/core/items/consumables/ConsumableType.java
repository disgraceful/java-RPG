package rpg.core.items.consumables;

import java.util.ArrayList;
import java.util.List;

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
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getDropRate() {
			return 40;
		}

	},

	BANDAGE {
		@Override
		public Item getItemToSpawn() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getDropRate() {
			return 50;
		}

	},

	ANTI_VENOM {
		@Override
		public Item getItemToSpawn() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getDropRate() {
			return 30;
		}
	},

	HOLY_WATER {
		@Override
		public Item getItemToSpawn() {
			return null;
		}

		@Override
		public int getDropRate() {
			return 25;
		}
	},

	DARK_ESSENCE {
		@Override
		public Item getItemToSpawn() {
			return null;
		}

		@Override
		public int getDropRate() {
			return 25;
		}
	};

	public static List<Item> spawnConsumableStack() {
		Consumable item = (Consumable) values()[CalcHelper.getRandomInt(values().length)].getItemToSpawn();
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
	
	private static Item chooseItemToSpawn(){
		int chance = CalcHelper.getRandomInt(101);
		return null;
	}

}
