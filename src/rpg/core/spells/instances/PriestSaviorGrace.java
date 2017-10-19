package rpg.core.spells.instances;

import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;
import rpg.core.spells.DeffensiveSpell;
import rpg.core.spells.SpellOrientation;
import rpg.core.spells.SpellPositionWrapper;
import rpg.core.spells.SpellTargetQuantity;

public class PriestSaviorGrace extends DeffensiveSpell {
	public PriestSaviorGrace() {
		name = "Savior Grace";
		description = "Priest is experienced in healing the most deadliest of wounds!";
		orientation = SpellOrientation.DEFFENSIVE;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnum.HEALTH, 3), new Stat(StatEnum.CRIT_MOD, 5));
		callerRequiredPos = new SpellPositionWrapper(2, 3);
		targetRequiredPos = new SpellPositionWrapper(0, 1, 2, 3);
	}
}
