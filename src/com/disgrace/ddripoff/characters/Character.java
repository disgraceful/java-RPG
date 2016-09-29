package com.disgrace.ddripoff.characters;

import java.util.ArrayList;

import com.disgrace.ddripoff.abilities.*;

import java.awt.*;

public class Character implements Comparable<Character>{
	protected String name;
	protected StatWrapper stats;
	protected ArrayList<ITemporaryEffect>tempEffects= new ArrayList<ITemporaryEffect>(); 
	protected ArrayList<Ability> allAbilities = new ArrayList<Ability>();
	protected Party party;
	
	public String getName(){
		return name;
	}
	
	public Character(String name) {
		this.name = name;
	}
		
	public StatWrapper getStatWrapper() {
		return stats;
	}
	
	public Party getParty(){
		return party;
	}
	
	public void setParty(Party party){
		this.party = party;
	}
	
	public ArrayList<ITemporaryEffect> getEffectsList(){
		return tempEffects;
	}
	
	public ArrayList<Ability> getAllAbilities() {
		return allAbilities;
	}
	
	public int getPosition(){
		return party.getPosition(this);
	}
	
	public void Move(int newposition){
		party.reposition(this, newposition);
	}
	
	@Override public int compareTo(Character c1) {
		int comparespeed = ((Character)c1).getStatWrapper().getStatbyName(StatEnumeration.SPEED).getCurValue();
		return comparespeed-this.stats.getStatbyName(StatEnumeration.SPEED).getCurValue();
	}
}
