package com.disgrace.ddripoff.spells;

import java.util.Random;

import com.disgrace.ddripoff.characters.shared.Character;

public abstract class TemporarySpell extends Spell implements TemporaryEffect{
	protected int abilityDuration;
	protected int currentDuration;
	private TemporaryEffectType effectType;
	
	public int getEffectDuration() {
		return abilityDuration;
	}

	public void setEffectDuration(int duration) {
		abilityDuration = duration;
	}

	public TemporaryEffectType getEffectType() {
		return effectType;
	}
	
	@Override
	public void useSpell(Character[] targets, Character caller) {
		for (Character t : targets) {
			if (ifDotApplies(t, caller)) {
				t.addEffect(this);
				System.out.println(t.getName() + " has been dotted");
			}
		}
	}

	private boolean ifDotApplies(Character target, Character caller) {
		int chance = new Random().nextInt(101);
		return chance> target.getStats().getProperResistValue(effectType);
	}
}
