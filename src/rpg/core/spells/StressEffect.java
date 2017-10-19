package rpg.core.spells;

import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatAffectStrategy;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;

public class StressEffect extends Effect {

	public StressEffect() {
	}

	public StressEffect(StatWrapper stats) {
		this.effectStats = stats;
	}

	@Override
	public void applyEffect(Character caller, Character target) {
		int stress = calcStressDamage(caller, target);
		Stat stat = new Stat(StatEnum.STRESS, stress, false, StatAffectStrategy.SUMMING_UP);
		target.updateStats(stat);
	}

	private int calcStressDamage(Character caller, Character target) {
		int stress = effectStats.getStatbyName(StatEnum.STRESS).getCurValue();
		stress *= isApplyingOnSelf(caller, target) ? 1 : (100 - getStressResistance(target)) / 100;
		return stress;
	}

	private int getStressResistance(Character target) {
		return target.getStatbyName(StatEnum.STRESS_RES).getCurValue();
	}

}
