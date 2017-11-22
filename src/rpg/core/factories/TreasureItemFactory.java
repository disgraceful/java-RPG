package rpg.core.factories;

import rpg.core.items.treasure.TreasureType;

public class TreasureItemFactory extends AbstractItemFactory{

	TreasureItemFactory() {
		itemToSpawn =TreasureType.GOLD;
	}

}
