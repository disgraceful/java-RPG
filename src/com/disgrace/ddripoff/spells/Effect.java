package com.disgrace.ddripoff.spells;
import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.StatWrapper;
public abstract class Effect {

	String description;
	StatWrapper effectStats;
	public abstract void applyEffect(Character caller,Character target);
	
	public StatWrapper getEffectStats() {
		return effectStats;
	}
	public void setEffectStats(StatWrapper effectStats) {
		this.effectStats = effectStats;
	}
}
