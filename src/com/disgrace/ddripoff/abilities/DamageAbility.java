package com.disgrace.ddripoff.abilities;

import java.util.ArrayList;

import com.disgrace.ddripoff.characters.stats.Stat;
import com.disgrace.ddripoff.characters.stats.StatEnumeration;
import com.disgrace.ddripoff.characters.stats.StatWrapper;

/**
 * 
 * @author Kashapov
 *
 *         Describes damage and heal abilities
 */
public abstract class DamageAbility extends Ability {

	protected StatEnumeration defType;// protection type

	/**
	 * Function called when ability is used
	 * 
	 * @param targets
	 *            ability targets
	 * @param user
	 *            character who used this ability
	 */
	@Override
	public void useAbility(StatWrapper[] targets, StatWrapper user) {
		for (StatWrapper t : targets) {
			int dmg = calculateDmg(t, user);
			// apply dealed damage to targets
			t.updateStats(calculateAbilityResult(dmg));
			if (dmg > 0) {
				System.out.println(user.getOwner().getName() + " used " + this.getName() + " and dealed " + dmg
						+ " damage to " + t.getOwner().getName());
			} else {
				System.out.println(user.getOwner().getName() + " used " + this.getName() + " and restored " + -dmg
						+ " health to " + t.getOwner().getName());
			}
		}
	}

	/**
	 * Calculates ability damage
	 * 
	 * @param target ability target(for defence stats)
	 * @param user ability user(for offence stats)
	 * @return damage dealed to target
	 */
	private int calculateDmg(StatWrapper target, StatWrapper user) {
		int potdmg = user.getStatbyName(StatEnumeration.DAMAGE).getCurValue();
		int realdmg;
		// check heal or dmg
		if (affectedStats.getStatbyName(StatEnumeration.DAMAGE).getCurValue() > 0) {
			// dmg
			potdmg += affectedStats.getStatbyName(StatEnumeration.DAMAGE).getCurValue();
			int targetdef = target.getStatbyName(defType).getCurValue();
			realdmg = potdmg - targetdef;// potdmg*(100-targetdef);
		} else {
			// heal for amount stated in ability description
			realdmg = affectedStats.getStatbyName(StatEnumeration.DAMAGE).getCurValue();
		}
		return realdmg;
	}

	/**
	 * transfer damage number into StatWrapper health/stress mask
	 * 
	 * @param damage number of real damage ready to be applied
	 * @return StatWrapper mask to apply on target's StatWrapper
	 */
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
