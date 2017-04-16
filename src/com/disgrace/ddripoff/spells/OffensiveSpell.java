package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.utils.CalculationHelper;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.SerializationUtils;

@XmlRootElement
public abstract class OffensiveSpell extends Spell implements Serializable {

	@Override
	public void initSpell() {
		orientation = SpellOrientation.OFFENSIVE;
	}

	@Override
	public void useSpell(Character caller, Character... targets) {
		for (Character target : targets) {
			if (!isMiss(caller, target)) {
				Stat damage = calculateDmg(caller, target);
				target.updateStats(damage);
				System.out.println(
						caller.toString() + " deals " + (-damage.getCurValue()) + " damage to" + target.toString());
				applyingEffects.stream()
						.forEach(e -> ((Effect) (SerializationUtils.clone(e))).applyEffect(caller, target));
			}
		}
		selfApplyingEffects.stream().forEach(e -> ((Effect) (SerializationUtils.clone(e))).applyEffect(caller, caller));
	}

	private Stat calculateDmg(Character caller, Character target) {
		float damage = CalculationHelper.calcRandomIntWithPercent(getBaseDamage(caller, damageType),
				SpellConstants.CALC_DISPERSION_25);
		System.out.println("Randomized Damage: " + damage);
		damage = isCrit(caller, target) ? (int) (damage * SpellConstants.CRIT_DAMAGE_MULTIPLIER) : damage;
		System.out.println("Critical Damage: " + damage);
		// damage*=()
		damage *= (100 + (getRangeDmgMod(caller) + getAbilityDamageMod())) / 100.0;
		System.out.println("Range Damage Amplifier: " + getRangeDmgMod(caller));
		System.out.println("Ability Damage Amplifiers: " + getAbilityDamageMod());
		System.out
				.println("Total Damage Increase percent: " + (100 + (getRangeDmgMod(caller) + getAbilityDamageMod())));
		System.out.println("Damage with Amplifiers: " + damage);
		damage *= (100 - target.getProperDeffenceValue(damageType)) / 100.0;
		System.out.println("Damage with defence: " + damage);
		return new Stat(StatEnumeration.HEALTH, -(int) damage);
	}

	private int getRangeDmgMod(Character caller) {
		return attackType == AttackType.MELEE ? caller.getStatbyName(StatEnumeration.MELEE_MOD).getCurValue()
				: caller.getStatbyName(StatEnumeration.RANGE_MOD).getCurValue();
	}

	private int getAbilityDamageMod() {
		return abilityStats.getStatbyName(StatEnumeration.DAMAGE_MOD).getCurValue();
	}

	private int getBaseDamage(Character caller, DamageType damageType) {
		switch (damageType) {
		case PHYSICAL:
			return caller.getStatbyName(StatEnumeration.DAMAGE).getCurValue();// caller.getStatbyName(StatEnumeration.DAMAGE).getCurValue();//
																				// +scaling
		// case MAGICAL:
		// return
		// 100;//caller.getStatbyName(StatEnumeration.INTELIGENCE).getCurValue()
		// * SpellConstants.DMG_PER_INT;
		// case LIGHTNING:
		// return
		// 100;//caller.getStatbyName(StatEnumeration.FAITH).getCurValue() *
		// SpellConstants.DMG_PER_FTH;
		// case FIRE:
		// return 100;// need to figure it out
		// case DARK:
		// return
		// 100;//caller.getStatbyName(StatEnumeration.STRESS).getCurValue()*
		// (SpellConstants.DMG_PER_STRESS +
		// caller.getStatbyName(StatEnumeration.CURSE_LEVEL).getCurValue());
		default:
			System.err.println("no such damage type");
			return 0;
		}

	}

}
