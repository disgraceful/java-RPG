package rpg.core.factories;

import rpg.core.items.trinkets.TrinketType;

public class TrinketFactory extends AbstractItemFactory {

	TrinketFactory() {
		itemToSpawn = TrinketType.TEST;
	}

}
