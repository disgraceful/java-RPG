package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.characters.shared.Character;

public abstract class Debuff extends TemporaryEffect {

	@Override
	public void applyEffect(Character caller, Character target) {
		if (isEffectApplying(caller, target)) {
			target.addEffect(this);
			System.out.println(
					this.effectType.toString() + " was applied on " + target.toString() + " for " + abilityDuration);
		} else {
			System.out.println(target.toString() + " resists!");
		}
	}

	@Override
	public void onTick(Character target) {
		if (currentDuration > 0) {
			currentDuration--;
			return;
		}
		onExpire(target);
	}

	@Override
	public void onExpire( Character target) {
		//reverse stats

	}

}
