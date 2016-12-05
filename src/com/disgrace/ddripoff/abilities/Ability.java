package com.disgrace.ddripoff.abilities;

import com.disgrace.ddripoff.characters.Character;
import com.disgrace.ddripoff.stats.StatWrapper;

public abstract class Ability {

	protected String name;
	protected String description;
	protected StatWrapper affectedStats;
	
	public String getName() {
		return name;
	}

	public StatWrapper getStats() {
		return affectedStats;
	}

	public String getDescription() {
		return description;
	}

	public abstract void useAbility(Character[] targets, Character caller);
	protected abstract void initAbility();

}
 