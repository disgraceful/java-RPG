package rpg.core.spells;

import org.apache.commons.lang.SerializationUtils;

import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.utils.CalcHelper;

public abstract class BasicSpell extends Spell {

	@Override
	public void useSpell(Character caller, Character... targets) {
		for (Character target : targets) {
			if (!isMiss(target)) {
				if (attackType != AttackType.SUPPORT) {
					Stat damage = calculateDamage(caller,target);
					target.updateStats(damage);
				}
				applyingEffects.stream()
						.forEach(e -> ((Effect) (SerializationUtils.clone(e))).applyEffect(caller, target));
			}
		}
		selfApplyingEffects.stream().forEach(e -> ((Effect) (SerializationUtils.clone(e))).applyEffect(caller, caller));
	}

	private boolean isMiss(Character target) {
		int targetDodge = target.getStatWrapper().getStatbyName(StatEnum.DODGE).getCurValue();
		int abilityAcc = abilityStats.getStatbyName(StatEnum.ACC).getCurValue();
		int trueAcc = abilityAcc - targetDodge;
		if (trueAcc > 90)
			trueAcc = 90;
		int hitChance = CalcHelper.randInt(101);
		if (attackType == AttackType.SUPPORT) {
			return false;
		}
		return hitChance > trueAcc ? true : false;
	}

	private Stat calculateDamage(Character caller,Character target) {
		double damage = abilityStats.getStatbyName(StatEnum.DAMAGE).getCurValue();
		damage*=((100+caller.getStatbyName(StatEnum.DAMAGE_MOD).getCurValue())/100);
		damage = CalcHelper.calcRandomIntWithPercent((int) damage, SpellConstants.CALC_DISPERSION_25);
		damage = calcCrit(damage);
		damage *= (100 - target.getStatbyName(StatEnum.PROT).getCurValue()) / 100.0;
		return new Stat(StatEnum.HEALTH, -(int) damage);
	}

	private double calcCrit(double damage) {
		double dmg = damage;
		int critChacne = abilityStats.getStatbyName(StatEnum.CRIT_CHANCE).getCurValue();
		int odds = CalcHelper.randInt(101);
		if (odds <= critChacne) {
			dmg *= SpellConstants.CRIT_DAMAGE_MULTIPLIER;
		}
		return dmg;
	}
}
