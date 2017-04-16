package com.disgrace.ddripoff.spells;

import org.apache.commons.lang.SerializationUtils;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.utils.CalculationHelper;

public abstract class BasicSpell extends Spell {

	@Override
	public void useSpell(Character caller, Character... targets) {
		for (Character target : targets) {
			if (!isMiss(target)) {
				Stat damage = calculateDamage(target);
				target.updateStats(damage);
				applyingEffects.stream()
						.forEach(e -> ((Effect) (SerializationUtils.clone(e))).applyEffect(caller, target));
			}
		}
		selfApplyingEffects.stream().forEach(e -> ((Effect) (SerializationUtils.clone(e))).applyEffect(caller, caller));
	}

	private boolean isMiss(Character target) {
		int targetDodge = target.getStatWrapper().getStatbyName(StatEnumeration.DODGE).getCurValue();
		int abilityAcc = abilityStats.getStatbyName(StatEnumeration.ACC).getCurValue();
		int trueAcc = abilityAcc - targetDodge;
		if (trueAcc > 90)
			trueAcc = 90;
		int hitChance = CalculationHelper.getRandomInt(101);
		if (attackType == AttackType.SUPPORT) {
			return false;
		}
		return hitChance > trueAcc ? true : false;
	}

	private Stat calculateDamage(Character target) {
		double damage = abilityStats.getStatbyName(StatEnumeration.DAMAGE).getCurValue();
		damage = CalculationHelper.calcRandomIntWithPercent((int) damage, SpellConstants.CALC_DISPERSION_25);
		damage = calcCrit(damage);
		if (attackType != AttackType.SUPPORT) {
			damage *= (100 - target.getProperDeffenceValue(damageType)) / 100.0;
		}
		return new Stat(StatEnumeration.HEALTH, -(int) damage);
	}

	private double calcCrit(double damage) {
		double dmg = damage;
		int critChacne = abilityStats.getStatbyName(StatEnumeration.CRIT_CHANCE).getCurValue();
		int odds = CalculationHelper.getRandomInt(101);
		if (odds <= critChacne) {
			if (attackType == AttackType.SUPPORT) {
				dmg *= SpellConstants.CRIT_HEAL_MULTIPLIER;
			} else {
				dmg *= SpellConstants.CRIT_DAMAGE_MULTIPLIER;
			}
		}
		return dmg;
	}

	public AttackType getAttackType() {
		return attackType;
	}

	public void setAttackType(AttackType attackType) {
		this.attackType = attackType;
	}

}
