package rpg.core.items.consumables;

import rpg.core.characters.shared.Character;
import rpg.core.items.ItemRarity;

public class HolyWater extends Consumable {
	public HolyWater() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Holy Water";
		description = "Blessed liquid offers potent resistances";
		cost = 250;
		quantityMultiplier = 1;
		stackQuantity = 5;
		maxSpawnedQuantity = 1;
		itemType = ConsumableType.HOLY_WATER;
		rarity = ItemRarity.RARE;
	}

	@Override
	public void use(Character c) {
		// ups resistances of "light" characters
	}
}
