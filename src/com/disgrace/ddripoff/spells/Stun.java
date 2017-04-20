package com.disgrace.ddripoff.spells;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

@XmlRootElement
public class Stun extends TemporaryEffect {

	public Stun() {
	}

	public Stun(StatWrapper stats) {
		abilityDuration = 1;
		currentDuration = abilityDuration;
		effectType = TemporaryEffectType.STUN;
		effectStats = stats;
	}

	@Override
	public void applyEffect(Character caller, Character target) {
		if (isEffectApplying(caller, target)) {
			target.addEffect(this);
			System.out.println(this.effectType.toString() + " was applied on " + target.toString() + " for "
					+ abilityDuration + " turns");
		} else {
			System.out.println(target.toString() + " resists!");
		}
	}

	@Override
	public void onTick(Character target) {
		if (currentDuration > 0) {
			currentDuration--;
		}
	}

	@Override
	public void onExpire(Character target) {
		// new StunLockPerventingBuff().applyEffect(target, target);
		System.out.println(this.toString() + " has expired");
	}
}
