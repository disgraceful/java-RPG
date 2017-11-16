package rpg.core.items.trinkets;

import rpg.core.characters.heroes.HeroClass;
import rpg.core.items.ItemRarity;

public class WreathOfCenturion extends Trinket {
	public WreathOfCenturion() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Wreath of Centurion";
		description = "Only most courageous and vigilant of warriors are gifted by these glorious leaves";
		cost = 750;
		itemType = TrinketType.WREATH_OF_CENTURION;
		rarity = ItemRarity.UNCOMMON;
		affectedstats = null;
		restriction = HeroClass.CENTURION;
	}
}
