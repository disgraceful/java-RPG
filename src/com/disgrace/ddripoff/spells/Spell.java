package com.disgrace.ddripoff.spells;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.characters.shared.CharacterClass;
import com.disgrace.ddripoff.characters.shared.Party;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public abstract class Spell {
	
//	protected StatWrapper affectedStats;
//	protected StatWrapper abilityStats;
//	protected RangeType range;
//	protected TargetType spellOrientation;
//	protected CharacterClass restrictionClass;
	protected SpellType spellType;
	protected SpellTargetQuantity spellTargetAmount;
	protected List<Effect> applyingEffects = new ArrayList<>();
	protected SpellPositionHelper callerRequiredPos = new SpellPositionHelper();
	protected SpellPositionHelper targetRequiredPos = new SpellPositionHelper();
	
	public List<Effect> getApplyingEffects() {
		return applyingEffects;
	}
	public void setApplyingEffects(List<Effect> applyingEffects) {
		this.applyingEffects = applyingEffects;
	}
	
	public SpellPositionHelper getCallerRequiredPos() {
		return callerRequiredPos;
	}
	public void setCallerRequiredPos(SpellPositionHelper callerRequiredPos) {
		this.callerRequiredPos = callerRequiredPos;
	}
	public SpellPositionHelper getTargetRequiredPos() {
		return targetRequiredPos;
	}
	public void setTargetRequiredPos(SpellPositionHelper targetRequiredPos) {
		this.targetRequiredPos = targetRequiredPos;
	}
	
	public abstract void useSpell(Character caller, Character target);
	public abstract void initSpell();

//	public StatWrapper getAffectingStats() {
//		return affectedStats;
//	}
//
//	public CharacterClass getRestrictionClass() {
//		return restrictionClass;
//	}
//
//	protected boolean isMiss(Character target, Character caller) {
//		int targetDodge = target.getStatWrapper().getStatbyName(StatEnumeration.DODGE).getCurValue();
//		int callerAcc = caller.getStatWrapper().getStatbyName(StatEnumeration.ACC).getCurValue();
//		int abilityAccMod = abilityStats.getStatbyName(StatEnumeration.ACC_MOD).getCurValue();
//		int totalAcc = callerAcc * abilityAccMod / 100;
//		int totalAccWithDodge = totalAcc - targetDodge;
//		if (totalAccWithDodge > 90)
//			totalAccWithDodge = 90;
//		int hitChance = new Random().nextInt(100 + 1);
//		if (hitChance > totalAccWithDodge) {
//			return true;// missed
//		} else if (hitChance < totalAccWithDodge && hitChance > totalAcc) {
//			return true;// dodged;
//		}
//		return false;
//	}
//
//	public boolean criticalStrike(Character target, Character caller) {
//		int callerCritChance = caller.getStatWrapper().getStatbyName(StatEnumeration.CRIT_CHANCE).getCurValue();
//		int abilityCritMod = abilityStats.getStatbyName(StatEnumeration.CRIT_MOD).getCurValue();
//		int totalCrit = callerCritChance + abilityCritMod;
//		int critChance = new Random().nextInt(100 + 1);
//		if (critChance < totalCrit) {
//			return true;
//		}
//		return false;
//	}
//
//	public List<Character> getAvaliableTargets(List<Character> queue, Character caller) {
//		List<Character> list = new ArrayList<>();
//		for (Character c : queue) {
//			if (isTargetAvaliable(c, caller)) {
//				list.add(c);
//			}
//		}
//		return list;
//	}
//
//	private boolean isTargetAvaliable(Character target, Character caller) {	
//		return (targetsRestrictedPos.contains(target.getPosition())&& (spellOrientation == TargetType.ENEMY && !caller.getCharClass().equals(target.getCharClass()))
//				|| (spellOrientation == TargetType.ALLY&&caller.getCharClass().equals(target.getCharClass())));
//	}


	
}

//enum TargetType {
//	ENEMY, ALLY;
//}
