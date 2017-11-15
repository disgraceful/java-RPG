package rpg.core.items.consumables;

import rpg.core.characters.shared.Character;
import rpg.core.items.ItemRarity;

public class Bandage extends Consumable {
	public Bandage() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Bandage";
		description = "Stops bleeding";
		cost = 50;
		quantityMultiplier = 1;
		stackQuantity = 5;
		maxSpawnedQuantity = 2;
		itemType = ConsumableType.BANDAGE;
		rarity = ItemRarity.COMMON;
	}

	@Override
	public void use(Character c) {
		//cure bleed
	}
}