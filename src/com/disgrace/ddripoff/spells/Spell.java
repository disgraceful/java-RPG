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
	protected String name;
	protected String description;
	protected SpellOrientation orientation;
	protected StatWrapper abilityStats;
	protected List<Effect> applyingEffects = new ArrayList<>();
	protected List<Effect> selfApplyingEffects = new ArrayList<>();
	protected SpellPositionWrapper callerRequiredPos = new SpellPositionWrapper();
	protected SpellPositionWrapper targetRequiredPos = new SpellPositionWrapper();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Effect> getApplyingEffects() {
		return applyingEffects;
	}

	public void setApplyingEffects(List<Effect> applyingEffects) {
		this.applyingEffects = applyingEffects;
	}

	public SpellPositionWrapper getCallerRequiredPos() {
		return callerRequiredPos;
	}

	public void setCallerRequiredPos(SpellPositionWrapper callerRequiredPos) {
		this.callerRequiredPos = callerRequiredPos;
	}

	public SpellPositionWrapper getTargetRequiredPos() {
		return targetRequiredPos;
	}

	public void setTargetRequiredPos(SpellPositionWrapper targetRequiredPos) {
		this.targetRequiredPos = targetRequiredPos;
	}

	public boolean isMiss(Character caller, Character target) {
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

	public boolean isCrit(Character caller, Character target) {
		int callerCritChance = caller.getStatbyName(StatEnumeration.CRIT_CHANCE) == null ? 0
				: caller.getStatbyName(StatEnumeration.CRIT_CHANCE).getCurValue();
		int abilityCritMod = abilityStats.getStatbyName(StatEnumeration.CRIT_MOD).getCurValue();
		int critChance = new Random().nextInt(101);
		if (critChance < callerCritChance + abilityCritMod) {
			return true;
		}
		return false;
	}

	public List<Character> getAvaliableTargets(Character caller, List<Character> queue) {
		List<Character> list = new ArrayList<>();
		for (Character c : queue) {
			if (isTargetAvaliable(c, caller)) {
				list.add(c);
			}
		}
		return list;
	}

	private boolean isTargetAvaliable(Character caller, Character target) {
		return isTargetInPosition(target) && orientation == SpellOrientation.OFFENSIVE
				? !target.getCharClass().equals(caller.getCharClass())
				: target.getCharClass().equals(caller.getCharClass());
	}

	private boolean isTargetInPosition(Character target) {
		return targetRequiredPos.isPosRequired(target.getPosition());
	}

	public abstract void useSpell(Character caller, Character... targets);

	public abstract void initSpell();
}
