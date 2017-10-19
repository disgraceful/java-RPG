package rpg.core.spells.instances;

import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatAffectStrategy;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;
import rpg.core.spells.Buff;
import rpg.core.spells.SpellOrientation;
import rpg.core.spells.SpellPositionWrapper;
import rpg.core.spells.SpellTargetQuantity;
import rpg.core.spells.UtilitySpell;

public class CenturionRiseShields extends UtilitySpell {
	public CenturionRiseShields() {
		name = "Rise Shields";
		description = "Centurion commands his men to take deffensive formation!";
		targetQuantity = SpellTargetQuantity.MULTIPLE;
		orientation = SpellOrientation.UTILITY;
		applyingEffects
				.add(new Buff(4, new StatWrapper(new Stat(StatEnum.PROT, 10, false, StatAffectStrategy.SUMMING_UP))));
		selfApplyingEffects
				.add(new Buff(4, new StatWrapper(new Stat(StatEnum.PROT, 10, false, StatAffectStrategy.SUMMING_UP))));
		callerRequiredPos = new SpellPositionWrapper(0);
		targetRequiredPos = new SpellPositionWrapper(0, 1, 2, 3);
	}
}
