package com.disgrace.ddripoff.spells;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public abstract class DamageSpell extends Spell {
	protected DamageType damageType;
	
	@Override
	public void useSpell(Character[] targets, Character caller) {
		for (Character target : targets) {
			if (calcualteMiss(target, caller)) {
				int damage = calculateDmg(target, caller);
				if(criticalStrike(target, caller))damage*=1.5;
				calculateAffectingStats(damage);
				target.getStats().updateStats(affectedStats);
			}
		}
	}
		
	private int calculateDmg(Character target, Character caller) {
		int callerDmg = caller.getStats().getStatbyName(StatEnumeration.DAMAGE).getCurValue();
		double callerDmgMin = callerDmg * 0.75;
		double callerDmgMax = callerDmg * 1.25;
		int randomizedDmg = (int) (new Random().nextInt((int) ((callerDmgMax - callerDmgMin) + 1)) + callerDmgMin);
		

		int realDmg = randomizedDmg * (100 - target.getStats().getProperDeffenceValue(damageType)) / 100;		
		return realDmg;
	}

	private void calculateAffectingStats(int damage) {
		List<Stat> list = new ArrayList<>();
		if (damageType == DamageType.STRESS) {
			list.add(new Stat(StatEnumeration.STRESS, damage, false));
		} else {
			list.add(new Stat(StatEnumeration.HEALTH, -damage, false));
		}
		affectedStats = new StatWrapper(list);
	}
}
