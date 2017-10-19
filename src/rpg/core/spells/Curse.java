package rpg.core.spells;

import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;

public class Curse extends TemporaryEffect {

	private int curseLevel;

	@Override
	public void applyEffect(Character caller, Character target) {
		if (isEffectApplying(caller, target)) {
			calcCurseStats(target);
			target.addEffect(this);
			target.updateStats(effectStats);
			System.out.println(this.effectType.toString() + " was applied on " + target.toString() + " for "
					+ abilityDuration + " turns");
		} else {
			System.out.println(target.toString() + " resists!");
		}

	}

	private void calcCurseStats(Character target) {
		Stat curse = target.getStatbyName(StatEnum.CURSE_LEVEL);
		curseLevel = curse.getCurValue();
		Stat hpStat = effectStats.getStatbyName(StatEnum.HEALTH);
		Stat dmgStat = effectStats.getStatbyName(StatEnum.DAMAGE);
		curseLevel = curseLevel >= 5 ? curseLevel : curseLevel++;
		curse.setValue(curseLevel);
		switch (curseLevel) {
		case 1:
			hpStat.setValue(-50);
			dmgStat.setValue(0);
			break;
		case 2:
			hpStat.setValue(-60);
			dmgStat.setValue(0);
			break;
		case 3:
			hpStat.setValue(-75);
			dmgStat.setValue(10);
			break;
		case 4:
			hpStat.setValue(-90);
			dmgStat.setValue(15);
			break;
		case 5:
			hpStat.setValue(-99);
			dmgStat.setValue(25);
			// TODO new trait = Darkin (+100% Sress Resistance)!
			break;
		}
		
		effectStats = new StatWrapper(curse,hpStat,dmgStat);
	}

	@Override
	public void onExpire(Character target) {
		target.updateStats(StatWrapper.reverseStats(effectStats));
	}

	@Override
	public void onTick(Character target) {
		// TODO Auto-generated method stub

	}

}
