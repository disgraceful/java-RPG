package rpg.core.items;

import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.utils.CalcHelper;

public class Food extends Consumable {
	public Food() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Food";
		description = "Yummy-yummy";
		cost = 5;
		maxSpawnQuanitity = 24;
		inventoryFitQuantity = 24;
	}

	@Override
	public void use(Character c) {
		c.updateStats(new Stat(StatEnum.HEALTH, CalcHelper.getRandomIntInRange(1, 2)));
	}

}
