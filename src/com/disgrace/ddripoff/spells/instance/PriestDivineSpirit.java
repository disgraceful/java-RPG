package com.disgrace.ddripoff.spells.instance;

import com.disgrace.ddripoff.spells.DeffensiveSpell;
import com.disgrace.ddripoff.spells.SpellOrientation;
import com.disgrace.ddripoff.spells.SpellPositionWrapper;
import com.disgrace.ddripoff.spells.SpellTargetQuantity;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class PriestDivineSpirit extends DeffensiveSpell {
	public PriestDivineSpirit() {
		name = "Savior Grace";
		description = "The wielder of gods' power can call for their mercy!";
		orientation = SpellOrientation.DEFFENSIVE;
		targetQuantity = SpellTargetQuantity.MULTIPLE;
		abilityStats = new StatWrapper(new Stat(StatEnumeration.HEALTH, 1), new Stat(StatEnumeration.CRIT_MOD, 5));
		callerRequiredPos = new SpellPositionWrapper(2, 3);
		targetRequiredPos = new SpellPositionWrapper(0, 1, 2, 3);
	}
}
