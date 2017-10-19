package rpg.core.spells;

import org.apache.commons.lang.SerializationUtils;

import rpg.core.characters.enemies.Enemy;
import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.utils.CalcHelper;

public abstract class OffensiveSpell extends Spell {

	@Override
	public void useSpell(Character caller, Character... targets) {
		for (Character target : targets) {
			if (!isMiss(caller, target)) {
				Stat damage = calculateDmg(caller, target);
				target.updateStats(damage);
				System.out.println(
						caller.toString() + " deals " + (-damage.getCurValue()) + " damage to" + target.toString());
				applyingEffects.stream()
						.forEach(e -> ((Effect) (SerializationUtils.clone(e))).applyEffect(caller, target));
			}
		}
		selfApplyingEffects.stream().forEach(e -> ((Effect) (SerializationUtils.clone(e))).applyEffect(caller, caller));
	}

	private Stat calculateDmg(Character caller, Character target) {
		float damage = CalcHelper.calcRandomIntWithPercent(caller.getStatbyName(StatEnum.DAMAGE).getCurValue(),
				SpellConstants.CALC_DISPERSION_25);
		damage *= (100 + (getRangeDmgMod(caller) + getAbilityDamageMod() + getCallerSpecificDamageMod(caller, target)
				+ getAbilitySpecificDamageMod(target) + getMarkedDamageMod(target))) / 100.0;
		damage = isCrit(caller, target) ? (int) (damage * SpellConstants.CRIT_DAMAGE_MULTIPLIER) : damage;
		damage *= (100 - target.getStatbyName(StatEnum.PROT).getCurValue()) / 100.0;
		return new Stat(StatEnum.HEALTH, -(int) damage);
	}

	private int getMarkedDamageMod(Character target) {
		return target.getEffectsWrapper().isEffectAppliedByType(TemporaryEffectType.MARK)
				? abilityStats.getStatbyName(StatEnum.MARK_DMG_MOD).getCurValue() : 0;
	}

	private int getCallerSpecificDamageMod(Character caller, Character target) {
		return caller.getProperSpecificDamageMod((Enemy) target);
	}

	private int getAbilitySpecificDamageMod(Character target) {
		return abilityStats.getProperSpecificDamageMod((Enemy) target);
	}

	private int getRangeDmgMod(Character caller) {
		return attackType == AttackType.MELEE ? caller.getStatbyName(StatEnum.MELEE_MOD).getCurValue()
				: caller.getStatbyName(StatEnum.RANGE_MOD).getCurValue();
	}

	private int getAbilityDamageMod() {
		return abilityStats.getStatbyName(StatEnum.DAMAGE_MOD).getCurValue();
	}

}
