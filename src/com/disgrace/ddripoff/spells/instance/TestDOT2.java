package com.disgrace.ddripoff.spells.instance;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.spells.DOT;
import com.disgrace.ddripoff.spells.TemporaryEffectType;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

@XmlRootElement
public class TestDOT2 extends DOT {
	public TestDOT2() {
		abilityDuration = 3;
		currentDuration = abilityDuration;
		tickDamage = effectStats.getStatbyName(StatEnumeration.HEALTH);
		currentTick = tickDamage;
		effectType = TemporaryEffectType.BLEED;
		effectStats = new StatWrapper(new Stat(StatEnumeration.BLEED_CHANCE, 220),
				new Stat(StatEnumeration.HEALTH, -2));

	}
}
