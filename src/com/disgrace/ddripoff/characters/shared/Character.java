package com.disgrace.ddripoff.characters.shared;

import java.util.ArrayList;
import java.util.List;

import com.disgrace.ddripoff.spells.DamageType;
import com.disgrace.ddripoff.spells.SpellEnum;
import com.disgrace.ddripoff.spells.TemporarySpell;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public abstract class Character implements Comparable<Character> {
	protected String name;
	protected StatWrapper stats;

	protected CharacterTempEffectsWrapper tempEffects = new CharacterTempEffectsWrapper();
	protected List<SpellEnum> allAbilities = new ArrayList<>();
	protected Party party;

	public String getName() {
		return name;
	}

	public StatWrapper getStatWrapper() {
		return stats;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public CharacterTempEffectsWrapper getEffectsWrapper() {
		return tempEffects;
	}

	public List<TemporarySpell> getTempEffects() {
		return tempEffects.getTempEffects();
	}

	public void addEffect(TemporarySpell effect) {
		tempEffects.addEffect(effect);
	}

	public StatWrapper getStats() {
		return stats;
	}

	public List<SpellEnum> getAllSpells() {
		return allAbilities;
	}

	public int getPosition() {
		return party.getPosition(this);
	}

	public void move(int newposition) {
		party.reposition(this, newposition);
	}

	public boolean isCharDead() {
		return stats.isCharDead();
	}

	public void charDied() {
		party.removeMember(this);
		System.out.println("RIP " + name);
	}

	public boolean isCharStunned() {
		return tempEffects.isStunned();
	}

	// public void rollbackTempSpellEffect(TemporarySpell spell) {
	// if (spell == null) {
	// return;
	// }
	// stats.rollbackTempSpellEffect(spell);
	// System.out.println(name + "get cleansed from " + spell.toString());
	// }

	public void useAbility(SpellEnum ability, Character[] targets) {
		ability.castSpell(targets, this);
	}

	public static Character spawn(CharacterClass charClass) {
		return charClass.getCharacterToSpawn();
	}

	protected abstract void init();

	@Override
	public int compareTo(Character c1) {
		int comparespeed = c1.getStatWrapper().getStatbyName(StatEnumeration.SPEED).getCurValue();
		return comparespeed - stats.getStatbyName(StatEnumeration.SPEED).getCurValue();
	}

	public abstract Class<?> getCharClass();

	public void updateStats(StatWrapper affectedStats) {
		if (affectedStats == null) {
			return;
		}
		stats.updateStats(affectedStats);
	}

	public void updateStats(Stat stat) {
		if (stat == null) {
			return;
		}
		stats.updateStats(stat);
	}

	public Stat getStatbyName(StatEnumeration type) {
		return stats.getStatbyName(type);
	}
	
	public Stat getProperDeffence(DamageType type){
		return stats.getProperDeffence(type);
	}
	
	public int getProperDeffenceValue(DamageType type){
		return stats.getProperDeffenceValue(type);
	}

}