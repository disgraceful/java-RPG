package com.disgrace.ddripoff.spells.instance;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.spells.DOT;
import com.disgrace.ddripoff.spells.TemporaryEffectType;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

@XmlRootElement
public class TestDOT extends DOT {
	public TestDOT() {
		abilityDuration = 2;
		currentDuration = abilityDuration;
		effectType =TemporaryEffectType.BLEED;
		effectStats = new StatWrapper(new Stat(StatEnumeration.BLEED_CHANCE, 220),new Stat(StatEnumeration.HEALTH, -1));
		tickDamage = effectStats.getStatbyName(StatEnumeration.HEALTH);
		currentTick = tickDamage;
	}
}
