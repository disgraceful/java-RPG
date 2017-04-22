package com.disgrace.ddripoff.spells.instance;

import com.disgrace.ddripoff.spells.AttackType;
import com.disgrace.ddripoff.spells.DOT;
import com.disgrace.ddripoff.spells.DamageType;
import com.disgrace.ddripoff.spells.OffensiveSpell;
import com.disgrace.ddripoff.spells.SpellOrientation;
import com.disgrace.ddripoff.spells.SpellPositionWrapper;
import com.disgrace.ddripoff.spells.SpellTargetQuantity;
import com.disgrace.ddripoff.spells.TemporaryEffectType;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class DishonoredBloodyRedemption extends OffensiveSpell {
	public DishonoredBloodyRedemption() {
		name = "Bloody Redemption";
		description = "The guilty will pay the price!";
		orientation = SpellOrientation.OFFENSIVE;
		attackType = AttackType.MELEE;
		damageType = DamageType.PHYSICAL;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnumeration.DAMAGE_MOD, 0), new Stat(StatEnumeration.ACC, 65),
				new Stat(StatEnumeration.CRIT_MOD, 0));
		applyingEffects.add(new DOT(3,new StatWrapper(new Stat(StatEnumeration.BLEED_CHANCE, 120),new Stat(StatEnumeration.HEALTH, -1)),TemporaryEffectType.BLEED));
		callerRequiredPos = new SpellPositionWrapper(0, 1);
		targetRequiredPos = new SpellPositionWrapper(1, 2);
	}
}
