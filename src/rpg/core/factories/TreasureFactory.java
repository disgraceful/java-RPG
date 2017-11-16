package rpg.core.factories;

import rpg.core.items.treasure.TreasureType;

public class TreasureFactory extends AbstractItemFactory{

	TreasureFactory() {
		itemToSpawn =TreasureType.GOLD;
	}

}
