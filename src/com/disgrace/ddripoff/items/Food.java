package com.disgrace.ddripoff.items;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.utils.CalculationHelper;
@XmlRootElement
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
		c.updateStats(new Stat(StatEnumeration.HEALTH, CalculationHelper.getRandomIntInRange(1, 2)));
	}

}
