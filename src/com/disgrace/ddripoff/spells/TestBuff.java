package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public  abstract class TestBuff extends Buff {
	public TestBuff() {
		description = "Description: Buffs target Health and Protection for 3 turns!";
		abilityDuration = 3;
		currentDuration = abilityDuration;
		effectType =TemporaryEffectType.BUFF;
		effectStats = new StatWrapper(new Stat(StatEnumeration.HEALTH, 5),new Stat(StatEnumeration.PHYS_PROT, 10));
		
	}
}
