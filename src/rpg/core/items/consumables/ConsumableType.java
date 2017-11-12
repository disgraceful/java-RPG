package rpg.core.items.consumables;

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
	
	KEY{
		@Override
		public Item getItemToSpawn() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getDropRate() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	},
	
	BANDAGE{
		@Override
		public Item getItemToSpawn() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getDropRate() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	},
	
	ANTI_VENOM{
		@Override
		public Item getItemToSpawn() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getDropRate() {
			// TODO Auto-generated method stub
			return 0;
		}	
	},
	
	HOLY_WATER{
		@Override
		public Item getItemToSpawn() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getDropRate() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	},
	
	DARK_ESSENCE{

		@Override
		public Item getItemToSpawn() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getDropRate() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	};
	
	public static Consumable spawnConsumable() {
		return (Consumable) values()[CalcHelper.getRandomInt(values().length)].getItemToSpawn();
	}

}
