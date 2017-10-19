package rpg.core.spells;

import org.apache.commons.lang.SerializationUtils;

import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.utils.CalcHelper;

public abstract class DeffensiveSpell extends Spell {


	@Override
	public void useSpell(Character caller, Character... targets) {
		for (Character target : targets) {
			target.updateStats(calculateHeal(target, caller));
			applyingEffects.stream().forEach(e -> ((Effect) (SerializationUtils.clone(e))).applyEffect(caller,target));
		}
		selfApplyingEffects.stream().forEach(e -> ((Effect) (SerializationUtils.clone(e))).applyEffect(caller,caller));
	}

	private Stat calculateHeal(Character caller, Character target) {
		int baseHeal = CalcHelper.calcRandomIntWithPercent(
				abilityStats.getStatbyName(StatEnum.HEALTH).getCurValue(), SpellConstants.CALC_DISPERSION_25);
		System.out.println("Randomized heal value: "+ baseHeal);
		baseHeal = isCrit(target, caller) ? (int) (baseHeal * SpellConstants.CRIT_HEAL_MULTIPLIER) : baseHeal;
		System.out.println("Crit heal: " + baseHeal);
		return new Stat(StatEnum.HEALTH, baseHeal);
	}
}
