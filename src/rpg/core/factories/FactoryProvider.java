package rpg.core.factories;

import rpg.core.dungeon.events.SpawnableEventType;
import rpg.core.items.ItemType;

public class FactoryProvider {

	private FactoryProvider() {
	}

	public static AbstractItemFactory getItemFactory(int chance) {
		if (chance < ItemType.TRINKET.getDrop()) {
			return new TrinketItemFactory();
		} else if (chance < ItemType.CONSUMABLE.getDrop()) {
			return new ConsumableItemFactory();
		} else {
			return new TreasureItemFactory();
		}
	}

	public static AbstractEventFactory getEventFactory(SpawnableEventType event) {
		switch (event) {
		case CURIO:
			return new CurioEventFactory();
		case TREASURE:
			return new TreasureEventFactory();
		case FIGHT:
		default:
			return new FightEventFactory();
		}
	}
}
