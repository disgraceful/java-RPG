package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class TestDebuff extends Debuff {
	public TestDebuff() {
		description = "Description: Debuffs target Protection for 3 turns!";
		abilityDuration = 3;
		currentDuration = abilityDuration;
		effectType = TemporaryEffectType.BUFF;
		effectStats = new StatWrapper(new Stat(StatEnumeration.PHYS_PROT, -10));

	}

}
