package rpg.core.factories;

import rpg.core.items.ItemType;

public class FactoryProvider {

	private FactoryProvider(){	
	}
	
	public static AbstractItemFactory getFactory(int chance) {
		if (chance < ItemType.TRINKET.getDrop()) {
			return new TrinketFactory();
		} else if (chance < ItemType.CONSUMABLE.getDrop()) {
			return new ConsumableFactory();
		} else {
			return new TreasureFactory();
		}
	}
}
