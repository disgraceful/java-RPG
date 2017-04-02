package com.disgrace.ddripoff.spells;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
@XmlRootElement
public abstract class DOT extends TemporaryEffect {

	Stat tickDamage;
	Stat currentTick;

	public Stat getCurrentTick() {
		return currentTick;
	}

	public void setCurrentTick(int currentTickDamage) {
		this.currentTick.setValue(currentTickDamage);
	}

	@Override
	public void applyEffect(Character caller, Character target) {
		if (isEffectApplying(caller, target)) {
			target.addEffect(this);
			System.out.println(this.effectType.toString() + " was applied on " + target.toString() + " for "
					+ currentDuration + " turns");
		} else {
			System.out.println(target.toString() + " resists!");
		}

	}

	@Override
	public void onTick(Character target) {
		if (currentDuration > 0) {
			currentDuration--;
			target.updateStats(currentTick);
			System.out.println(target.getName() + " suffers for " + currentTick.getCurValue());
		}
	}

	@Override
	public void onExpire(Character target) {
		System.out.println(this.toString() + " has expired");
	}
}
