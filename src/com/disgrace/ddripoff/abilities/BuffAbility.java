package com.disgrace.ddripoff.abilities;

import java.util.List;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.spells.TemporaryEffect;
import com.disgrace.ddripoff.spells.TemporaryEffectType;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatWrapper;

public abstract class BuffAbility extends SpellEnum implements TemporaryEffect {
	private int abilityDuration;
	private int currentDuration;
	private final TemporaryEffectType effectType;

	public BuffAbility(String name, List<Stat> stat, int duration, TemporaryEffectType effecttype) {
		abilityDuration = duration;
		effectType = effecttype;
		currentDuration = abilityDuration;
	}

	public BuffAbility(BuffAbility a) {
		this(a.getName(), a.getAffectingStats().getStatsasArrayList(), a.getEffectDuration(), a.getEffectType());
	}

	@Override
	public void useAbility(Character[] targets, Character user) {
		for (Character c : targets) {
			c.getStats().updateStats(affectedStats);
			c.addEffect(this);
		}
	}

	@Override
	public void onTick(Character target) {
		if (currentDuration >= 0) {
			currentDuration--;
		} else {
			onExpire(target);
		}
	}

	@Override
	public void onExpire(Character target) {
		StatWrapper.reverseStatsValue(affectedStats);
		target.getStats().updateStats(affectedStats);
		// System.out.println(getName() + " duration has been expired on " + t.getOwner().getName());

	}

	public int getEffectDuration() {
		return abilityDuration;
	}

	public TemporaryEffectType getEffectType() {
		return effectType;
	}

}
