package rpg.core.items.consumables;

import rpg.core.characters.shared.Character;

public class AntiVenom extends Consumable {
	public AntiVenom() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "AntiVenom";
		description = "Cures poisoning";
		cost = 50;
		quantityMultiplier = 1;
		stackQuantity = 5;
		maxSpawnedQuantity = 2;
		itemType = ConsumableType.ANTI_VENOM;
	}

	@Override
	public void use(Character c) {
		//cure poison
	}
}
