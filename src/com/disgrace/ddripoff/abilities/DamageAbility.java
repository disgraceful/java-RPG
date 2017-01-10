package com.disgrace.ddripoff.abilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public abstract class DamageAbility extends CombatAbility {
	@Override
	public void useAbility(Character[] targets, Character caller) {
		for (Character t : targets) {
			if (calcualteMiss(t, caller)) {
				int dmg = calculateDmg(t, caller);
				if(criticalStrike(t, caller))dmg*=1.5;
				calculateAffectingStats(dmg);
				t.getStats().updateStats(affectedStats);
			}
		}
	}

	private int calculateDmg(Character target, Character caller) {
		int callerDmg = caller.getStats().getStatbyName(StatEnumeration.DAMAGE).getCurValue();
		double callerDmgMin = callerDmg * 0.75;
		double callerDmgMax = callerDmg * 1.25;
		int randomizedDmg = (int) (new Random().nextInt((int) ((callerDmgMax - callerDmgMin) + 1)) + callerDmgMin);

		int realDmg = randomizedDmg * (100 - target.getProperDeffenceValue(dmgType)) / 100;		
		return realDmg;
	}

	private void calculateAffectingStats(int damage) {
		List<Stat> list = new ArrayList<>();
		if (dmgType == DamageType.STRESS) {
			list.add(new Stat(StatEnumeration.STRESS, damage, false));
		} else {
			list.add(new Stat(StatEnumeration.HEALTH, -damage, false));
		}
		affectedStats = new StatWrapper(list);
	}
}
