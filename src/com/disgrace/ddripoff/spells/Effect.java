package com.disgrace.ddripoff.spells;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.StatWrapper;

@XmlRootElement
public abstract class Effect implements Serializable {
	String description;
	StatWrapper effectStats;

	public StatWrapper getEffectStats() {
		return effectStats;
	}

	public void setEffectStats(StatWrapper effectStats) {
		this.effectStats = effectStats;
	}

	public boolean isApplyingOnSelf(Character caller, Character target) {
		return caller.getCharClass().equals(target.getCharClass());
	}

	public abstract void applyEffect(Character caller, Character target);
}
