package rpg.core.items.trinkets;

import rpg.core.characters.heroes.HeroClass;
import rpg.core.items.ItemRarity;

public class RuneShield extends Trinket {
	public RuneShield() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Rune Shield";
		description = "Shield with anceint runes, probably provides some extra defences";
		cost = 750;
		itemType = TrinketType.RUNE_SHIELD;
		rarity = ItemRarity.COMMON;
		affectedstats = null;
		restriction = HeroClass.CENTURION;
	}
}
