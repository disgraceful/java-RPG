package abilities.ddripoffmodel;

import java.util.ArrayList;

import ddripoffmodel.Stat;
import ddripoffmodel.StatEnumeration;
import ddripoffmodel.StatWrapper;

/**
 * 
 * @author Kashapov
 *
 *         Describes damage and heal abilities
 */
public class DamageAbility extends Ability {

	StatEnumeration defType;// protection type

	/**
	 * 
	 * @param name
	 *            used as name of ability
	 * @param stat
	 *            damage caused by ability
	 * @param deftype
	 *            stat used to defy protection type from ability damage
	 */
	public DamageAbility(String name, ArrayList<Stat> stat, StatEnumeration deftype) {
		super(name, stat);
		defType = deftype;
	}

	/**
	 * Function called when ability is used
	 * 
	 * @param targets
	 *            ability targets
	 * @param user
	 *            character who used this ability
	 */
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
	 * @param target
	 *            ability target(for defence stats)
	 * @param user
	 *            ability user(for offence stats)
	 * @return damage dealed to target
	 */
	private int calculateDmg(StatWrapper target, StatWrapper user) {
		int potdmg = user.getStatbyName(StatEnumeration.Damage).getCurValue();
		int realdmg;
		// check heal or dmg
		if (affectedStats.getStatbyName(StatEnumeration.Damage).getCurValue() > 0) {
			// dmg
			potdmg += affectedStats.getStatbyName(StatEnumeration.Damage).getCurValue();
			int targetdef = target.getStatbyName(defType).getCurValue();
			realdmg = potdmg - targetdef;// potdmg*(100-targetdef);
		} else {
			// heal for amount stated in ability description
			realdmg = affectedStats.getStatbyName(StatEnumeration.Damage).getCurValue();
		}
		return realdmg;
	}

	/**
	 * transfer damage number into health/stress loss/gain
	 * 
	 * @param damage
	 *            number of real damage ready to be applied
	 * @return
	 */
	private StatWrapper calculateAbilityResult(int damage) {
		if (defType == StatEnumeration.StressResist) {
			StatWrapper s = new StatWrapper(new ArrayList<Stat>() {
				{
					add(new Stat(StatEnumeration.Stress, damage, false));
				}
			});
			return s;
		} else {
			StatWrapper s = new StatWrapper(new ArrayList<Stat>() {
				{
					add(new Stat(StatEnumeration.Health, -damage, false));
				}
			});
			return s;
		}
	}
}
