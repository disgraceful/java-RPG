package rpg.core.items.consumables;

import rpg.core.characters.shared.Character;
import rpg.core.items.ItemRarity;

public class DarkEssence extends Consumable {
	public DarkEssence() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Dark Essence";
		description = "Dark and unstable matter, only one desperate enough could dare to use it";
		cost = 250;
		quantityMultiplier = 1;
		stackQuantity = 5;
		maxSpawnedQuantity = 1;
		itemType = ConsumableType.DARK_ESSENCE;
		rarity = ItemRarity.RARE;
	}

	@Override
	public void use(Character c) {
		//buffs damage on "dark" characters
	}

}
