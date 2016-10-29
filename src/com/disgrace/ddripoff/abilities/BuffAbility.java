package com.disgrace.ddripoff.abilities;

import java.util.ArrayList;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatWrapper;

/**
 * Covers temporary buff and debuff abilities
 * 
 * @author Kashapov
 *
 */
public abstract class BuffAbility extends Ability implements ITemporaryEffect {
	/**
	 * Constructor
	 * 
	 * Calls base class constructor with name and stat
	 * 
	 * @param name(required)
	 *            name of ability
	 * @param stat(required)
	 *            stats affected by ability
	 * @param duration(required)
	 *            duration of ability(turns)
	 * @param effecttype(required)buff/debuff
	 */
	public BuffAbility(String name, ArrayList<Stat> stat, int duration, TemporaryEffect effecttype) {
			abilityDuration = duration;
		effectType = effecttype;
	}

	/** duration of buff/debuff */
	private int abilityDuration;
	/** effect type: buff or debuff */
	private final TemporaryEffect effectType;

	/**
	 * Clone constructor
	 * 
	 * makes a copy of object a
	 * 
	 * @param a
	 */
	public BuffAbility(BuffAbility a) {
		this(a.getName(), a.getStats().getStatsasArrayList(), a.getEffectDuration(), a.getEffectType());
	}

	@Override
	public void useAbility(StatWrapper[] targets, StatWrapper user) {
		for (StatWrapper t : targets) {
			t.updateStats(affectedStats);
			//t.getOwner().getEffectsList().add(new BuffAbility(this));
			System.out.println(t.getOwner().getName() + " has been buffed");
		}
	}

	@Override
	public void expireEffect(StatWrapper[] targets) {
		StatWrapper.reverseStatsValue(affectedStats);
		for (StatWrapper t : targets) {
			t.updateStats(affectedStats);
			System.out.println(getName() + " duration has been expired on " + t.getOwner().getName());
		}
	}
	@Override
	public int getEffectDuration() {
		return abilityDuration;
	}
	@Override
	public void setEffectDuration(int duration) {
		if (duration < 1) {
			abilityDuration = 1;
		} else {
			abilityDuration = duration;
		}
	}

	@Override
	public TemporaryEffect getEffectType() {
		return effectType;
	}

	@Override
	public void tickEffect(StatWrapper t) {
		if (abilityDuration >= 0) {
			this.abilityDuration--;
		}
	}

}
