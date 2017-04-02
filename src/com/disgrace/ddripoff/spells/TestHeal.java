package com.disgrace.ddripoff.spells;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

@XmlRootElement
public class TestHeal extends DeffensiveSpell {
	public TestHeal() {
		initSpell();
	}

	@Override
	public void initSpell() {
		super.initSpell();
		name = "Just Healing Spell";
		description = "Description: Heals an ally";
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnumeration.HEALTH, 7), new Stat(StatEnumeration.CRIT_MOD, 0));
		callerRequiredPos = new SpellPositionWrapper(0, 1, 2, 3);
		targetRequiredPos = new SpellPositionWrapper(0, 1, 2, 3);
	}
}
