package rpg.core.factories;

import rpg.core.items.trinkets.TrinketType;

public class TrinketItemFactory extends AbstractItemFactory {

	TrinketItemFactory() {
		itemToSpawn = TrinketType.ETCHED_SHIELD;
	}

}
