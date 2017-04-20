package com.disgrace.ddripoff.spells;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

@XmlRootElement
public abstract class Spell implements Serializable {
	protected String name;
	protected String description;
	protected SpellOrientation orientation;
	protected SpellTargetQuantity targetQuantity;
	protected DamageType damageType;
	protected AttackType attackType;
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

	public SpellOrientation getOrientation() {
		return orientation;
	}

	public void setOrientation(SpellOrientation orientation) {
		this.orientation = orientation;
	}

	public SpellTargetQuantity getTargetQuantity() {
		return targetQuantity;
	}

	public void setTargetQuantity(SpellTargetQuantity targetQuantity) {
		this.targetQuantity = targetQuantity;
	}

	public DamageType getDamageType() {
		return damageType;
	}

	public void setDamageType(DamageType damageType) {
		this.damageType = damageType;
	}

	public StatWrapper getAbilityStats() {
		return abilityStats;
	}

	public void setAbilityStats(StatWrapper abilityStats) {
		this.abilityStats = abilityStats;
	}

	public List<Effect> getSelfApplyingEffects() {
		return selfApplyingEffects;
	}

	public void setSelfApplyingEffects(List<Effect> selfApplyingEffects) {
		this.selfApplyingEffects = selfApplyingEffects;
	}

	public void setTargetRequiredPos(SpellPositionWrapper targetRequiredPos) {
		this.targetRequiredPos = targetRequiredPos;
	}

	public AttackType getAttackType() {
		return attackType;
	}

	public void setAttackType(AttackType attackType) {
		this.attackType = attackType;
	}

	public boolean isMiss(Character caller, Character target) {
		int targetDodge = target.getStatWrapper().getStatbyName(StatEnumeration.DODGE).getCurValue();
		int callerAccMod = caller.getStatWrapper().getStatbyName(StatEnumeration.ACC_MOD).getCurValue();
		int abilityAcc = abilityStats.getStatbyName(StatEnumeration.ACC).getCurValue();
		int trueAcc = callerAccMod + abilityAcc - targetDodge;
		if (trueAcc > 90)
			trueAcc = 90;
		System.out.println("targetDodge: " + targetDodge + " callerAccMod: " + callerAccMod + " abilityAcc: "
				+ abilityAcc + " trueAcc: " + trueAcc);
		int hitChance = new Random().nextInt(100 + 1);
		System.out.println("hitChance: " + hitChance);
		return hitChance > trueAcc ? true : false;
	}

	public boolean isCrit(Character caller, Character target) {
		int callerCritChance = caller.getStatbyName(StatEnumeration.CRIT_CHANCE) == null ? 0
				: caller.getStatbyName(StatEnumeration.CRIT_CHANCE).getCurValue();
		System.out.println("caller Crit Chance: " + callerCritChance);
		int abilityCritMod = abilityStats.getStatbyName(StatEnumeration.CRIT_MOD).getCurValue();
		System.out.println("ability Crit Mod " + abilityCritMod);
		int critChance = new Random().nextInt(101);
		System.out.println("total Crit: " + critChance);
		return critChance <= callerCritChance + abilityCritMod ? true : false;
	}

	public List<Character> getAvaliableTargets(Character caller, List<Character> queue) {
		List<Character> list = new ArrayList<>();
		for (Character c : queue) {
			if (isTargetAvaliable(caller, c)) {
				list.add(c);
			}
		}
		return list;
	}

	private boolean isTargetAvaliable(Character caller, Character target) {
		return isTargetInPosition(target) && (isSpellOffensive() ? !target.getCharClass().equals(caller.getCharClass())
				: target.getCharClass().equals(caller.getCharClass()));
	}

	private boolean isTargetInPosition(Character target) {
		return targetRequiredPos.isPosRequired(target.getPosition());
	}

	private boolean isSpellOffensive() {
		return orientation == SpellOrientation.OFFENSIVE;
	}

	public boolean isSpellAOE() {
		return targetQuantity == SpellTargetQuantity.MULTIPLE;
	}

	public abstract void useSpell(Character caller, Character... targets);

	public abstract void initSpell();
}
