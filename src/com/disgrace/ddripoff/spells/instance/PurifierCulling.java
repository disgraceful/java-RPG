package com.disgrace.ddripoff.spells.instance;

import com.disgrace.ddripoff.spells.AttackType;
import com.disgrace.ddripoff.spells.DamageType;
import com.disgrace.ddripoff.spells.OffensiveSpell;
import com.disgrace.ddripoff.spells.SpellOrientation;
import com.disgrace.ddripoff.spells.SpellPositionWrapper;
import com.disgrace.ddripoff.spells.SpellTargetQuantity;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class PurifierCulling extends OffensiveSpell {
	public PurifierCulling() {
		name = "Culling";
		description = "Cull the darkin!";
		orientation = SpellOrientation.OFFENSIVE;
		attackType = AttackType.RANGE;
		damageType = DamageType.PHYSICAL;
		targetQuantity = SpellTargetQuantity.MULTIPLE;
		abilityStats = new StatWrapper(new Stat(StatEnumeration.DAMAGE_MOD, -40), new Stat(StatEnumeration.ACC, 60),
				new Stat(StatEnumeration.CRIT_MOD, 5));
		callerRequiredPos = new SpellPositionWrapper(2,3);
		targetRequiredPos = new SpellPositionWrapper(0, 1,2);
	}
}
