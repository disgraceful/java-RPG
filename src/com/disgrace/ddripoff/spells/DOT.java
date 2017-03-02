package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;

public abstract class DOT extends TemporaryEffect {

	Stat tickDamage;
	Stat currentTick=tickDamage;
	
	public Stat getCurrentTick() {
		return currentTick;
	}

	public void setCurrentTick(int currentTickDamage) {
		this.currentTick.setValue(currentTickDamage);
	}
	
	@Override
	public void applyEffect(Character caller, Character target) {
		tickDamage = effectStats.getStatbyName(StatEnumeration.HEALTH);
		if (isEffectApplying(caller, target)) {
			target.addEffect(this);
			System.out.println(
					this.effectType.toString() + " was applied on " + target.toString() + " for " + currentDuration + " turns");
		} else {
			System.out.println(target.toString() + " resists!");
		}

	}

	@Override
	public void onTick(Character target) {
		if (currentDuration > 0) {
			currentDuration--;
			target.updateStats(currentTick);
			System.out.println(target.getName()+ " suffers for " + currentTick.getCurValue());
			return;
		}
		onExpire(target);
	}

	@Override
	public void onExpire(Character target) {
		System.out.println(this.toString() + " has expired");
	}
}
