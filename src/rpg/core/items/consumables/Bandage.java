package rpg.core.items.consumables;

import rpg.core.characters.shared.Character;

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
	}

	@Override
	public void use(Character c) {
		//cure bleed
	}
}