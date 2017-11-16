package rpg.core.items.trinkets;

import rpg.core.characters.heroes.HeroClass;
import rpg.core.items.ItemRarity;

public class EtchedShield extends Trinket {
	public EtchedShield() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Etched Shield";
		description = "An old shield with inspiring words of legatus etched on it";
		cost = 2500;
		itemType = TrinketType.ETCHED_SHIELD;
		rarity = ItemRarity.RARE;
		affectedstats = null;
		restriction = HeroClass.CENTURION;
	}
}
