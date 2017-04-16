package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class TestBasicOffSpell extends BasicSpell {

	public TestBasicOffSpell() {
		initSpell();
	}

	@Override
	public void initSpell() {
		name = "Just Damaging Spell for Enemies";
		description = "Description: Damages an opponent!";
		attackType = AttackType.MELEE;
		damageType = DamageType.PHYSICAL;
		orientation = SpellOrientation.OFFENSIVE;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnumeration.DAMAGE, 5), new Stat(StatEnumeration.ACC, 60),
				new Stat(StatEnumeration.CRIT_CHANCE, 5));
		callerRequiredPos = new SpellPositionWrapper(0, 1, 2, 3);
		targetRequiredPos = new SpellPositionWrapper(0, 1);
	}
}
