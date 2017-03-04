package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class TestDOT2 extends DOT {
	public TestDOT2() {
		description = "Description: Poisons Enemy for 2 damage for 3 turns";
		abilityDuration = 3;
		currentDuration = abilityDuration;
		currentTick = tickDamage;
		effectType =TemporaryEffectType.BLEED;
		effectStats = new StatWrapper(new Stat(StatEnumeration.BLEED_CHANCE, 220),new Stat(StatEnumeration.HEALTH, -2));
		tickDamage = effectStats.getStatbyName(StatEnumeration.HEALTH);
		currentTick = tickDamage;
	}
}
