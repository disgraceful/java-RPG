package com.disgrace.ddripoff.spells;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

@XmlRootElement
public class TestDebuff extends Debuff {
	public TestDebuff() {
		description = "Description: Debuffs target Protection for 3 turns!";
		abilityDuration = 2;
		currentDuration = abilityDuration;
		effectType = TemporaryEffectType.DEBUFF;
		effectStats = new StatWrapper(new Stat(StatEnumeration.DEBUFF_CHANCE,220),new Stat(StatEnumeration.PHYS_PROT, -10));

	}

}
