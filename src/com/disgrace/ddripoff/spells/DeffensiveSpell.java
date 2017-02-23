package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.utils.CalculationHelper;

public abstract class DeffensiveSpell extends Spell {

	@Override
	public void initSpell() {
		orientation = SpellOrientation.DEFFENSIVE;
	}

	@Override
	public void useSpell(Character caller, Character... targets) {
		for (Character target : targets) {
			target.updateStats(calculateHeal(target, caller));
			applyingEffects.stream().forEach(e -> e.applyEffect(target));
			selfApplyingEffects.stream().forEach(e -> e.applyEffect(caller));
		}
	}

	private Stat calculateHeal(Character caller, Character target) {
		int baseHeal = CalculationHelper.calcRandomIntWithPercent(
				abilityStats.getStatbyName(StatEnumeration.HEALTH).getCurValue(), SpellConstants.CALC_DISPERSION_25);
		baseHeal = isCrit(target, caller) ? (int) (baseHeal * SpellConstants.CRIT_HEAL_MULTIPLIER) : baseHeal;
		return new Stat(StatEnumeration.HEALTH, baseHeal);
	}
}
