package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.utils.CalculationHelper;

public abstract class OffensiveSpell extends Spell {
	protected DamageType damageType;
	protected RangeType range;

	@Override
	public void initSpell() {
		orientation = SpellOrientation.OFFENSIVE;
	}

	@Override
	public void useSpell(Character caller, Character... targets) {
		for (Character target : targets) {
			if (isMiss(caller, target)) {
				target.updateStats(calculateDmg(caller, target));
				applyingEffects.stream().forEach(e -> e.applyEffect(target));
				selfApplyingEffects.stream().forEach(e -> e.applyEffect(caller));
			}
		}
	}
	
	private Stat calculateDmg(Character caller, Character target) {
		int damage = CalculationHelper.calcRandomIntWithPercent(getBaseDamage(caller, damageType),SpellConstants.CALC_DISPERSION_25);
		damage=isCrit(caller, target)?(int)(damage*SpellConstants.CRIT_DAMAGE_MULTIPLIER):damage;
		damage*=(100+(getRangeDmgMod(caller)+getAbilityDamageMod()))/100;
		damage*=(100-target.getProperDeffenceValue(damageType))/100;
		return new Stat(StatEnumeration.HEALTH, damage);
	}

	private int getRangeDmgMod(Character caller) {
		return range == RangeType.MELEE ? caller.getStatbyName(StatEnumeration.MELEE_MOD).getCurValue()
				: caller.getStatbyName(StatEnumeration.RANGE_MOD).getCurValue();
	}
	
	private int getAbilityDamageMod(){
		return abilityStats.getStatbyName(StatEnumeration.DAMAGE_MOD).getCurValue();
	}

	private int getBaseDamage(Character caller, DamageType damageType) {
		switch (damageType) {
		case PHYSICAL:
			return 5;//caller.getStatbyName(StatEnumeration.DAMAGE).getCurValue();// +scaling
		case MAGICAL:
			return 100;//caller.getStatbyName(StatEnumeration.INTELIGENCE).getCurValue() * SpellConstants.DMG_PER_INT;
		case LIGHTNING:
			return 100;//caller.getStatbyName(StatEnumeration.FAITH).getCurValue() * SpellConstants.DMG_PER_FTH;
		case FIRE:
			return 100;// need to figure it out
		case DARK:
			return 100;//caller.getStatbyName(StatEnumeration.STRESS).getCurValue()* (SpellConstants.DMG_PER_STRESS + caller.getStatbyName(StatEnumeration.CURSE_LEVEL).getCurValue());
		default:
			System.err.println("no such damage type");
			return 0;
		}

	}

}