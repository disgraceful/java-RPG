package rpg.core.spells;

import java.io.Serializable;

import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.StatWrapper;

public abstract class Effect implements Serializable {
	protected StatWrapper effectStats;

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
