package abilities.ddripoffmodel;

import java.util.ArrayList;

import ddripoffmodel.Stat;
import ddripoffmodel.StatWrapper;

/**
 * Model for Characters' Abilities
 * 
 * <P>
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
	public Ability(String name, ArrayList<Stat> stat) {
		this.name = name;
		this.affectedStats = new StatWrapper(stat);
	}
	

	/** basic fields */
	private String name;
	protected StatWrapper affectedStats;
	protected String description;

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
	 * Set ability description
	 * 
	 * Moved from constructor because it is supposed to be wall of text
	 */
	public void setDecsription(String description) {
		this.description = description;
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
