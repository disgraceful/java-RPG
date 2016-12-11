package com.disgrace.ddripoff.abilities;

import java.util.Random;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public abstract class CombatAbility extends Ability implements Critable{
	protected StatWrapper abilityStats;
	protected DamageType dmgType;
	protected RangeType rangeType;

	public StatWrapper getAbilityStats() {
		return abilityStats;
	}

	protected boolean calcualteMiss(Character target, Character caller) {
		int targetDodge = target.getStatWrapper().getStatbyName(StatEnumeration.DODGE).getCurValue();
		int callerAcc = caller.getStatWrapper().getStatbyName(StatEnumeration.ACC).getCurValue();
		int abilityAccMod = abilityStats.getStatbyName(StatEnumeration.ACC_MOD).getCurValue();
		int totalAcc = callerAcc * abilityAccMod / 100;
		int totalAccWithDodge = totalAcc - targetDodge;
		if (totalAccWithDodge > 90) totalAccWithDodge = 90;
		int hitChance = new Random().nextInt(100 + 1);
		if (hitChance > totalAccWithDodge) {
			return true;// missed
		} else if (hitChance < totalAccWithDodge & hitChance > totalAcc) {
			return true;// doded;
		}
		return false;
	}

	@Override
	public boolean criticalStrike(Character target, Character caller) {
		int callerCritChance = caller.getStatWrapper().getStatbyName(StatEnumeration.CRIT_CHANCE).getCurValue();
		int abilityCritMod = abilityStats.getStatbyName(StatEnumeration.CRIT_MOD).getCurValue();
		int totalCrit = callerCritChance+abilityCritMod;
		int critChance = new Random().nextInt(100 + 1);
		if(critChance<totalCrit){
			return true;
		}
		return false;
		
	}
}
