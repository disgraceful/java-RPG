package com.disgrace.ddripoff.spells.instance;

import com.disgrace.ddripoff.spells.AttackType;
import com.disgrace.ddripoff.spells.DamageType;
import com.disgrace.ddripoff.spells.Move;
import com.disgrace.ddripoff.spells.OffensiveSpell;
import com.disgrace.ddripoff.spells.SpellOrientation;
import com.disgrace.ddripoff.spells.SpellPositionWrapper;
import com.disgrace.ddripoff.spells.SpellTargetQuantity;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class DishonoredChainedDeath extends OffensiveSpell {
	public DishonoredChainedDeath() {
		name = "Chained Death";
		description = "Noone will escape the hook of the unforgiven!";
		orientation = SpellOrientation.OFFENSIVE;
		attackType = AttackType.RANGE;
		damageType = DamageType.PHYSICAL;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnumeration.DAMAGE_MOD, -55), new Stat(StatEnumeration.ACC, 80),
				new Stat(StatEnumeration.CRIT_MOD, 0));
		applyingEffects.add(new Move(new StatWrapper(new Stat(StatEnumeration.MOVE_CHANCE, 120),
				new Stat(StatEnumeration.MOVE_SPELL_POSITION, 2))));
		callerRequiredPos = new SpellPositionWrapper(1, 2);
		targetRequiredPos = new SpellPositionWrapper(1, 2, 3);
	}
}
