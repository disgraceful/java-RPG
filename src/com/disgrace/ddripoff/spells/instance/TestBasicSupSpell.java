package com.disgrace.ddripoff.spells.instance;

import java.io.Serializable;

import com.disgrace.ddripoff.spells.AttackType;
import com.disgrace.ddripoff.spells.BasicSpell;
import com.disgrace.ddripoff.spells.HealEffect;
import com.disgrace.ddripoff.spells.SpellOrientation;
import com.disgrace.ddripoff.spells.SpellPositionWrapper;
import com.disgrace.ddripoff.spells.SpellTargetQuantity;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class TestBasicSupSpell extends BasicSpell implements Serializable {
	public TestBasicSupSpell() {
		name = "Just Supporting Spell for Enemies";
		description = "Description: Heals target! ";
		attackType = AttackType.SUPPORT;
		orientation = SpellOrientation.DEFFENSIVE;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnumeration.DAMAGE, 0), new Stat(StatEnumeration.ACC, 0),
				new Stat(StatEnumeration.CRIT_CHANCE, 0));
		applyingEffects.add(new HealEffect(new StatWrapper(new Stat(StatEnumeration.HEALTH, 6))));
		callerRequiredPos = new SpellPositionWrapper(0, 1, 2, 3);
		targetRequiredPos = new SpellPositionWrapper(0, 1);
	}


}
