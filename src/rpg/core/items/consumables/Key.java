package rpg.core.items.consumables;

import rpg.core.characters.shared.Character;
import rpg.core.items.ItemRarity;

public class Key extends Consumable {
	public Key() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Key";
		description = "Old key that opens locks";
		cost = 100;
		quantityMultiplier = 1;
		stackQuantity = 5;
		maxSpawnedQuantity = 2;
		itemType = ConsumableType.KEY;
		rarity = ItemRarity.UNCOMMON;
	}

	@Override
	public void use(Character c) {
		// cant use, only locks door
	}
}