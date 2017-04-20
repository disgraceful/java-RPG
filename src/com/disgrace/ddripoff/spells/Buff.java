package com.disgrace.ddripoff.spells;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

@XmlRootElement
public class Buff extends TemporaryEffect {

	public Buff() {
	}

	public Buff(int duration, StatWrapper stats) {
		abilityDuration = duration;
		currentDuration = abilityDuration;
		effectType = TemporaryEffectType.BUFF;
		effectStats = stats;
	}

	@Override
	public void applyEffect(Character caller, Character target) {
		target.addEffect(this);
		target.updateStats(effectStats);
		System.out.println(this.effectType.toString() + " was applied on " + target.toString() + " for "
				+ abilityDuration + " turns");
	}

	@Override
	public void onTick(Character target) {
		if (currentDuration > 0) {
			currentDuration--;
		}
	}

	@Override
	public void onExpire(Character target) {
		target.updateStats(StatWrapper.reverseStats(effectStats));
		System.out.println(this.toString() + " was expired on " + target.toString());
	}
}
