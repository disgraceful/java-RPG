package rpg.core.items.consumables;

import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.items.ItemRarity;
import rpg.core.utils.CalcHelper;

public class Food extends Consumable {
	public Food() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Food";
		description = "Packed products to prevent hunger";
		cost = 5;
		quantityMultiplier = 2;
		stackQuantity = 24;
		maxSpawnedQuantity = 12;
		itemType = ConsumableType.FOOD;
		rarity = ItemRarity.COMMON;
	}

	@Override
	public void use(Character c) {
		c.updateStats(new Stat(StatEnum.HEALTH, CalcHelper.getRandomIntInRange(1, 2)));
	}

}
