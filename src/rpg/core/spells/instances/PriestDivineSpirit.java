package rpg.core.spells.instances;

import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;
import rpg.core.spells.DeffensiveSpell;
import rpg.core.spells.SpellOrientation;
import rpg.core.spells.SpellPositionWrapper;
import rpg.core.spells.SpellTargetQuantity;

public class PriestDivineSpirit extends DeffensiveSpell {
	public PriestDivineSpirit() {
		name = "Savior Grace";
		description = "The wielder of gods' power can call for their mercy!";
		orientation = SpellOrientation.DEFFENSIVE;
		targetQuantity = SpellTargetQuantity.MULTIPLE;
		abilityStats = new StatWrapper(new Stat(StatEnum.HEALTH, 1), new Stat(StatEnum.CRIT_MOD, 5));
		callerRequiredPos = new SpellPositionWrapper(2, 3);
		targetRequiredPos = new SpellPositionWrapper(0, 1, 2, 3);
	}
}
