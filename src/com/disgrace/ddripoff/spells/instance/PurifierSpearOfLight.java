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

public class PurifierSpearOfLight extends OffensiveSpell {
	public PurifierSpearOfLight() {
		name = "Spear of Light";
		description = "Sun always rises!";
		orientation = SpellOrientation.OFFENSIVE;
		attackType = AttackType.RANGE;
		damageType = DamageType.PHYSICAL;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnumeration.DAMAGE_MOD, 50), new Stat(StatEnumeration.ACC, 65),
				new Stat(StatEnumeration.CRIT_MOD, 5));
		callerRequiredPos = new SpellPositionWrapper(3, 4);
		targetRequiredPos = new SpellPositionWrapper(0, 1, 2);
	}
}
