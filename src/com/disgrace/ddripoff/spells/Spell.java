package com.disgrace.ddripoff.spells;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.characters.shared.CharacterClass;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public abstract class Spell {
	protected String name;
	protected String description;
	protected StatWrapper affectedStats;
	protected StatWrapper abilityStats;
	protected RangeType range;
	SpellEnum spellClass;
	protected CharacterClass restrictionClass;
	protected List<Integer> callerRestrictedPos =  new ArrayList<>(); 
	protected List<Integer> targetsRestrictedPos =  new ArrayList<>();

	public String getName() {
		return name;
	}

	public StatWrapper getAffectingStats() {
		return affectedStats;
	}

	public String getDescription() {
		return description;
	}

	public CharacterClass getRestrictionClass() {
		return restrictionClass;
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
		} else if (hitChance < totalAccWithDodge && hitChance > totalAcc) {
			return true;// doded;
		}
		return false;
	}

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
	
	public abstract void useSpell(Character[] targets, Character caller);
	public void initSpell(){}
}
