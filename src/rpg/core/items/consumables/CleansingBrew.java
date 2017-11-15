package rpg.core.items.consumables;

import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.items.ItemRarity;
import rpg.core.utils.CalcHelper;

public class CleansingBrew extends Consumable {
	public CleansingBrew() {
		initItem();
	}

	@Override
	protected void initItem() {
		name = "Cleansing brew";
		description = "Potent brew of powerful mixtures";
		cost = 100;
		quantityMultiplier = 1;
		stackQuantity = 5;
		maxSpawnedQuantity = 1;
		itemType = ConsumableType.CLEANSING_BREW;
		rarity =ItemRarity.UNCOMMON;
	}

	@Override
	public void use(Character c) {
		//cleanses debuffs
	}
}
