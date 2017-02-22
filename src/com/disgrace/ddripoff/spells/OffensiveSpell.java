package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.Stat;

public abstract class OffensiveSpell extends Spell {
	protected DamageType damageType;
	protected RangeType range;

	private Stat calculateDmg(Character target, Character caller) {
		
	}

	@Override
	public void useSpell(Character caller, Character... targets) {
		for (Character target : targets) {
			if (isMiss(caller, target)) {
				target.updateStats(calculateDmg(target, caller));
				applyingEffects.stream().forEach(e -> e.applyEffect(target));
				selfApplyingEffects.stream().forEach(e -> e.applyEffect(caller));
			}
		}
	}

}
