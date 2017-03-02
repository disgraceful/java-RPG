package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class TestDOT extends DOT {
	public TestDOT() {
		description = "Description: Poisons Enemy for 1 damage for 2 turns";
		abilityDuration = 2;
		currentDuration = abilityDuration;
		currentTick = effectStats.getStatbyName(StatEnumeration.HEALTH);
		effectType =TemporaryEffectType.BLEED;
		effectStats = new StatWrapper(new Stat(StatEnumeration.BLEED_CHANCE, 220),new Stat(StatEnumeration.HEALTH, -1));
	}
}
