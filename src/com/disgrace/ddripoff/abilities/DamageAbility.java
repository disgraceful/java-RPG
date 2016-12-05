package com.disgrace.ddripoff.abilities;

import java.util.ArrayList;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;
import com.disgrace.ddripoff.characters.Character;

public abstract class DamageAbility extends Ability {

	protected StatEnumeration defType;// protection type

	@Override
	public void useAbility(Character[] targets, Character caller) {
		for (Character t : targets) {
			int dmg = calculateDmg(t,caller);
			// apply dealed damage to targets
			t.getStats().updateStats(calculateAbilityResult(dmg));
		}
	}

	private int calculateDmg(Character target, Character user) {
		int potdmg = user.getStats().getStatbyName(StatEnumeration.DAMAGE).getCurValue();
		int realdmg;
		// check heal or dmg
		if (affectedStats.getStatbyName(StatEnumeration.DAMAGE).getCurValue() > 0) {
			// dmg
			potdmg += affectedStats.getStatbyName(StatEnumeration.DAMAGE).getCurValue();
			int targetdef = target.getStats().getStatbyName(defType).getCurValue();
			realdmg = potdmg - targetdef;// potdmg*(100-targetdef);
		} else {
			// heal for amount stated in ability description
			realdmg = affectedStats.getStatbyName(StatEnumeration.DAMAGE).getCurValue();
		}
		return realdmg;
	}

	private StatWrapper calculateAbilityResult(int damage) {
		if (defType == StatEnumeration.STRESSRES) {
			StatWrapper s = new StatWrapper(new ArrayList<Stat>() {
				{
					add(new Stat(StatEnumeration.STRESS, damage, false));
				}
			});
			return s;
		} else {
			StatWrapper s = new StatWrapper(new ArrayList<Stat>() {
				{
					add(new Stat(StatEnumeration.HEALTH, -damage, false));
				}
			});
			return s;
		}
	}
}
