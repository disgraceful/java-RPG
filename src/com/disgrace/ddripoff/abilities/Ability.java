package com.disgrace.ddripoff.abilities;

import com.disgrace.ddripoff.characters.stats.StatWrapper;

/**
 * Model for Characters' Abilities
 * Basic variables and description
 * 
 * @author Kashapov Nail
 */
public abstract class Ability {

	/**
	 * Constructor
	 * 
	 * @param name(required)
	 *            Name of ability(not description)
	 * @param stat(required)/(didn't
	 *            decide yet) stats affected by ability
	 */
	
	
	/** basic fields */
	protected String name;
	protected String description;
	protected StatWrapper affectedStats;
	
	/** Return name of ability passed to constructor */
	public String getName() {
		return name;
	}

	/** Return affected by ability stats AS ArrayList */
	public StatWrapper getStats() {
		return affectedStats;
	}

	/** Return ability description(Supposed to be wall of text) */
	public String getDescription() {
		return description;
	}

	/**
	 * Method which called by Character whenever ability is used
	 * 
	 * @param targets(required)
	 *            Characters which are going to be affected by this ability
	 * @param user(required)/(optional?)
	 *            Character who used this ability
	 */
	public abstract void useAbility(StatWrapper[] targets, StatWrapper user);

}
 