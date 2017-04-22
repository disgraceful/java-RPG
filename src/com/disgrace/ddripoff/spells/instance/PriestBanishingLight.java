package com.disgrace.ddripoff.spells.instance;

import com.disgrace.ddripoff.spells.AttackType;
import com.disgrace.ddripoff.spells.DamageType;
import com.disgrace.ddripoff.spells.Debuff;
import com.disgrace.ddripoff.spells.OffensiveSpell;
import com.disgrace.ddripoff.spells.SpellOrientation;
import com.disgrace.ddripoff.spells.SpellPositionWrapper;
import com.disgrace.ddripoff.spells.SpellTargetQuantity;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class PriestBanishingLight extends OffensiveSpell {

	public PriestBanishingLight() {
		name = "Banishing Light";
		description = "The hand which heals, can also banish!";
		orientation = SpellOrientation.OFFENSIVE;
		attackType = AttackType.RANGE;
		damageType = DamageType.PHYSICAL;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnumeration.DAMAGE_MOD, -60), new Stat(StatEnumeration.ACC, 80),
				new Stat(StatEnumeration.CRIT_MOD, 0));
		applyingEffects.add(new Debuff(3,
				new StatWrapper(new Stat(StatEnumeration.DAMAGE, -90), new Stat(StatEnumeration.DEBUFF_CHANCE, 90))));
		callerRequiredPos = new SpellPositionWrapper(1, 2, 3);
		targetRequiredPos = new SpellPositionWrapper(0, 1, 2, 3);
	}

}
