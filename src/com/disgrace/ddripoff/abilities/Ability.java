package com.disgrace.ddripoff.abilities;

import java.util.ArrayList;
import java.util.List;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.characters.shared.CharacterClass;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatWrapper;

public abstract class Ability {

	protected String name;
	protected String description;
	protected StatWrapper affectedStats;
	
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

	public abstract void useAbility(Character[] targets, Character caller);
	protected abstract void initAbility();
	

}
 