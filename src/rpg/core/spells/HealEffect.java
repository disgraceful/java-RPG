package rpg.core.spells;

import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;
import rpg.core.utils.CalcHelper;


public class HealEffect extends Effect {

	public HealEffect() {
	}

	public HealEffect(StatWrapper effectStats) {
		this.effectStats = effectStats;
	}

	@Override
	public void applyEffect(Character caller, Character target) {
		target.updateStats(calcHeal());
	}

	private Stat calcHeal() {
		double healValue = effectStats.getStatbyName(StatEnum.HEALTH).getCurValue();
		healValue = CalcHelper.calcRandomIntWithPercent((int) healValue, SpellConstants.CALC_DISPERSION_30);
		return new Stat(StatEnum.HEALTH, (int) healValue);
	}

}
