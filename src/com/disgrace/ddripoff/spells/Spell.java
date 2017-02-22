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

	// protected StatWrapper affectedStats;
	// protected StatWrapper abilityStats;
	// protected RangeType range;
	// protected TargetType spellOrientation;
	// protected CharacterClass restrictionClass;
	protected StatWrapper abilityStats;
	protected List<Effect> applyingEffects = new ArrayList<>();
	protected List<Effect> selfApplyingEffects = new ArrayList<>();
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

	public abstract void useSpell(Character caller, Character... targets);

	public abstract void initSpell();

	public boolean isMiss(Character caller,Character target) {
		int targetDodge = target.getStatWrapper().getStatbyName(StatEnumeration.DODGE).getCurValue();
		int callerAcc = caller.getStatWrapper().getStatbyName(StatEnumeration.ACC).getCurValue();
		int totalAccWithDodge = callerAcc - targetDodge;
		if (totalAccWithDodge > 90)
			totalAccWithDodge = 90;
		int hitChance = new Random().nextInt(100 + 1);
		if (hitChance > totalAccWithDodge) {
			return true;// missed
		} else if (hitChance < totalAccWithDodge && hitChance > callerAcc) {
			return true;// dodged;
		}
		return false;
	}

	public boolean isCrit(Character caller,Character target) {
		int callerCritChance = caller.getStatbyName(StatEnumeration.CRIT_CHANCE) == null ? 0
				: caller.getStatbyName(StatEnumeration.CRIT_CHANCE).getCurValue();
		int abilityCritMod = abilityStats.getStatbyName(StatEnumeration.CRIT_MOD).getCurValue();
		int critChance = new Random().nextInt(101);
		if (critChance < callerCritChance + abilityCritMod) {
			return true;
		}
		return false;
	}
	//
	// public List<Character> getAvaliableTargets(List<Character> queue,
	// Character caller) {
	// List<Character> list = new ArrayList<>();
	// for (Character c : queue) {
	// if (isTargetAvaliable(c, caller)) {
	// list.add(c);
	// }
	// }
	// return list;
	// }
	//
	// private boolean isTargetAvaliable(Character target, Character caller) {
	// return (targetsRestrictedPos.contains(target.getPosition())&&
	// (spellOrientation == TargetType.ENEMY &&
	// !caller.getCharClass().equals(target.getCharClass()))
	// || (spellOrientation ==
	// TargetType.ALLY&&caller.getCharClass().equals(target.getCharClass())));
	// }

}

// enum TargetType {
// ENEMY, ALLY;
// }
