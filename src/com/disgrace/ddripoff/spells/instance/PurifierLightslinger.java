package com.disgrace.ddripoff.spells.instance;

import com.disgrace.ddripoff.spells.Buff;
import com.disgrace.ddripoff.spells.SpellOrientation;
import com.disgrace.ddripoff.spells.SpellPositionWrapper;
import com.disgrace.ddripoff.spells.SpellTargetQuantity;
import com.disgrace.ddripoff.spells.UtilitySpell;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class PurifierLightslinger extends UtilitySpell {
	public PurifierLightslinger() {
		name = "Lightslinger";
		description = "Double the gun, double the hurt!";
		orientation = SpellOrientation.UTILITY;
		targetQuantity = SpellTargetQuantity.SINGLE;
		applyingEffects.add(new Buff(1, new StatWrapper(new Stat(StatEnumeration.DAMAGE_MOD, 100))));
		callerRequiredPos = new SpellPositionWrapper(2, 3);
		targetRequiredPos = new SpellPositionWrapper(2, 3);
	}
}
