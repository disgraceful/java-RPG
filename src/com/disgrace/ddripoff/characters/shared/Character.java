package com.disgrace.ddripoff.characters.shared;

import java.util.ArrayList;
import java.util.List;

import com.disgrace.ddripoff.spells.SpellEnum;
import com.disgrace.ddripoff.spells.TemporaryEffect;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public abstract class Character implements Comparable<Character> {
	protected String name;
	protected StatWrapper stats;

	protected List<TemporaryEffect> tempEffects = new ArrayList<TemporaryEffect>();
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

	public List<TemporaryEffect> getEffectsList() {
		return tempEffects;
	}

	public void addEffect(TemporaryEffect effect) {
		if(effect==null){
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
	
		
	@Override
	public int compareTo(Character c1) {
		int comparespeed = c1.getStatWrapper().getStatbyName(StatEnumeration.SPEED).getCurValue();
		return comparespeed - this.stats.getStatbyName(StatEnumeration.SPEED).getCurValue();
	}

	protected abstract void init();
	public abstract void useAbility(SpellEnum ability,Character[] targets);
}
