package rpg.core.items.trinkets;

import rpg.core.characters.heroes.HeroClass;
import rpg.core.items.ItemRarity;

public class StoutShield extends Trinket {
	public StoutShield() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Stout Shield";
		description = "Shield like this is presented to a rookie after first battle";
		cost = 750;
		itemType = TrinketType.STOUT_SHIELD;
		rarity = ItemRarity.COMMON;
		affectedstats = null;
		restriction = HeroClass.CENTURION;
	}
}
