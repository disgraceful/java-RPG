package rpg.core.items.consumables;

import rpg.core.characters.shared.Character;

public class Key extends Consumable {
	public Key() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Key";
		description = "Old key that opens door";
		cost = 250;
		quantityMultiplier = 1;
		stackQuantity = 5;
		maxSpawnedQuantity = 2;
		itemType = ConsumableType.KEY;
	}

	@Override
	public void use(Character c) {
		//cant use, only locks door
	}
}