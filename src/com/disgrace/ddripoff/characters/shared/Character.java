package com.disgrace.ddripoff.characters.shared;

import java.util.ArrayList;
import java.util.List;

import com.disgrace.ddripoff.spells.SpellEnum;
import com.disgrace.ddripoff.spells.TemporaryEffectType;
import com.disgrace.ddripoff.spells.TemporarySpell;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public abstract class Character implements Comparable<Character> {
	protected String name;
	protected StatWrapper stats;

	protected List<TemporarySpell> tempEffects = new ArrayList<TemporarySpell>();
	protected List<SpellEnum> allAbilities = new ArrayList<SpellEnum>();
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

	public List<TemporarySpell> getEffectsList() {
		return tempEffects;
	}

	public void addEffect(TemporarySpell effect) {
		if (effect == null) {
			return;
		}
		tempEffects.add(effect);
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
		return stats.isCharStunned();
	}

	public void cleanseTempEffect(TemporarySpell spell) {
		if (spell == null) {
			return;
		}
		tempEffects.remove(spell);
		stats.cleanseEffect(spell);
	}

	@Override
	public int compareTo(Character c1) {
		int comparespeed = c1.getStatWrapper().getStatbyName(StatEnumeration.SPEED).getCurValue();
		return comparespeed - stats.getStatbyName(StatEnumeration.SPEED).getCurValue();
	}

	public void useAbility(SpellEnum ability, Character[] targets) {
		ability.castSpell(targets, this);
	}
	
	public static Character spawn(CharacterClass charClass){
		return charClass.getCharacterToSpawn();
	}
	
	protected abstract void init();
	
}