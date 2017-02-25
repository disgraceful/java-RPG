package com.disgrace.ddripoff.characters.shared;

import java.util.ArrayList;
import java.util.List;

import com.disgrace.ddripoff.spells.DamageType;
import com.disgrace.ddripoff.spells.Spell;
import com.disgrace.ddripoff.spells.SpellEnum;
import com.disgrace.ddripoff.spells.TemporaryEffect;
import com.disgrace.ddripoff.spells.TemporaryEffectType;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public abstract class Character implements Comparable<Character> {
	protected String name;
	protected StatWrapper stats;

	protected CharacterTempEffectsWrapper tempEffects = new CharacterTempEffectsWrapper();
	protected List<Spell> allAbilities = new ArrayList<>();
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

	public List<TemporaryEffect> getTempEffects() {
		return tempEffects.getTempEffects();
	}

	public void addEffect(TemporaryEffect effect) {
		tempEffects.addEffect(effect);
	}

	public StatWrapper getStats() {
		return stats;
	}

	public List<Spell> getAllSpells() {
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

	public void useAbility(Spell ability, Character... targets) {
		ability.useSpell(this, targets);
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
	
	@Override
	public String toString() {
		return name;
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

	public int getProperResistValue(TemporaryEffectType type){
		return stats.getProperResistValue(type);
	}
	
	public int getProperDeffenceValue(DamageType type){
		return stats.getProperDeffenceValue(type);
	}
	
	public int getProperMultiplierValue(TemporaryEffectType type){
		return stats.getProperMultiplierValue(type);
	}

}