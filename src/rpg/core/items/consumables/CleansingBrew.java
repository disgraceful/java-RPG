package rpg.core.items.consumables;

import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.utils.CalcHelper;

public class CleansingBrew extends Consumable {
	public CleansingBrew() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Cleansing Brew";
		description = "Potent brew of powerful mixtures";
		cost = 50;
		quantityMultiplier = 1;
		stackQuantity = 5;
		maxSpawnedQuantity = 1;
		itemType = ConsumableType.CLEANSING_BREW;
	}

	@Override
	public void use(Character c) {
		//cleanses debuffs
	}
}
