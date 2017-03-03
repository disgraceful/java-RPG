package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class TestStun extends Stun {
	public TestStun() {
		description = "Description: Stuns Enemy for 1 turn";
		abilityDuration = 1;
		currentDuration = abilityDuration;
		effectType =TemporaryEffectType.STUN;
		effectStats = new StatWrapper(new Stat(StatEnumeration.STUN_CHANCE, 220));
	}
}
