package com.disgrace.ddripoff.spells;

import java.util.Random;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.StatEnumeration;

public abstract class TemporarySpell extends Spell {
	protected int abilityDuration;
	protected int currentDuration;
	protected TemporaryEffectType effectType;
	
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
			if (isDotApplying(t, caller)) {
				t.addEffect(this);
				System.out.println(t.getName() + " has been dotted");
			}
		}
	}

	private boolean isDotApplying(Character target, Character caller) {
		int targetResist = target.getStats().getProperResistValue(effectType);
		int callerDotChanceMultiplier = caller.getStats().getProperMultiplierValue(effectType);
		int abilityChance = abilityStats.getProperMultiplierValue(effectType);
		int total = abilityChance+callerDotChanceMultiplier-targetResist;
		if(total>90){
			total=90;
		}
		return new Random().nextInt(101)>total; 
	}
	
	public abstract void onTick(Character target);
	public abstract void onExpire(Character target);
}
