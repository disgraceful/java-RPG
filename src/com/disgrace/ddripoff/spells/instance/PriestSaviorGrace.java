package com.disgrace.ddripoff.spells.instance;

import com.disgrace.ddripoff.spells.DeffensiveSpell;
import com.disgrace.ddripoff.spells.SpellOrientation;
import com.disgrace.ddripoff.spells.SpellPositionWrapper;
import com.disgrace.ddripoff.spells.SpellTargetQuantity;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class PriestSaviorGrace extends DeffensiveSpell {
	public PriestSaviorGrace() {
		name = "Savior Grace";
		description = "Priest is experienced in healing the most deadliest of wounds!";
		orientation = SpellOrientation.DEFFENSIVE;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnumeration.HEALTH, 3), new Stat(StatEnumeration.CRIT_MOD, 5));
		callerRequiredPos = new SpellPositionWrapper(2, 3);
		targetRequiredPos = new SpellPositionWrapper(0, 1, 2, 3);
	}
}
