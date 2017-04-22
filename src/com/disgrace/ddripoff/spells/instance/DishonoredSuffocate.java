package com.disgrace.ddripoff.spells.instance;

import com.disgrace.ddripoff.spells.AttackType;
import com.disgrace.ddripoff.spells.DamageType;
import com.disgrace.ddripoff.spells.OffensiveSpell;
import com.disgrace.ddripoff.spells.SpellOrientation;
import com.disgrace.ddripoff.spells.SpellPositionWrapper;
import com.disgrace.ddripoff.spells.SpellTargetQuantity;
import com.disgrace.ddripoff.spells.Stun;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class DishonoredSuffocate extends OffensiveSpell {
	public DishonoredSuffocate() {
		name = "Suffocate";
		description = "Suffocate as he once did!";
		orientation = SpellOrientation.OFFENSIVE;
		attackType = AttackType.RANGE;
		damageType = DamageType.PHYSICAL;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnumeration.DAMAGE_MOD, -40), new Stat(StatEnumeration.ACC, 85),
				new Stat(StatEnumeration.CRIT_MOD, 5));
		applyingEffects.add(new Stun(new StatWrapper(new Stat(StatEnumeration.STUN_CHANCE, 90))));
		callerRequiredPos = new SpellPositionWrapper(0, 1,2);
		targetRequiredPos = new SpellPositionWrapper(1, 2);
	}
}
