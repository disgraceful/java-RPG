package rpg.core.items.trinkets;

import rpg.core.characters.heroes.HeroClass;
import rpg.core.items.ItemRarity;

public class HonorableVitis extends Trinket {
	public HonorableVitis() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Honorable Vitis";
		description = "The symbol of centurions' rights and power";
		cost = 5000;
		itemType = TrinketType.HONORABLE_VITIS;
		rarity = ItemRarity.EPIC;
		affectedstats = null;
		restriction = HeroClass.CENTURION;
	}
}