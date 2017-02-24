package com.disgrace.ddripoff.spells;

import java.util.ArrayList;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;
import com.disgrace.ddripoff.utils.CalculationHelper;

public abstract class HealSpell extends Spell {

//	protected HealSpellType healingStat;
//
//	@Override
//	public void useSpell(Character[] targets, Character caller) {
//		for (Character target : targets) {
//			int healValue = calcHealValue(getProperBaseValue());
//			if (isCrit(target, caller)) {
//				healValue *= 1.25;
//			}
//			target.updateStats(getProperStatWrapper(healValue));
//			System.out.println(target.getName() + " was healed for " + Math.abs(healValue));
//		}
//	}
//
//	private int calcHealValue(int baseValue) {
//		return CalculationHelper.calcRandomIntWithPercent(baseValue, 0.25);
//	}
//
//	private int getProperBaseValue() {
//		return healingStat == HealSpellType.HEALTH ? abilityStats.getStatbyName(StatEnumeration.HEALTH).getCurValue()
//				: abilityStats.getStatbyName(StatEnumeration.STRESS).getCurValue();
//	}
//
//	private StatWrapper getProperStatWrapper(int value) {
//		return healingStat == HealSpellType.HEALTH ? new StatWrapper(new ArrayList<Stat>() {
//			{
//				add(new Stat(StatEnumeration.HEALTH, value, false));
//			}
//		}) : new StatWrapper(new ArrayList<Stat>() {
//			{
//				add(new Stat(StatEnumeration.STRESS, value, false));
//			}
//			
//			
//		});
//	}
//
//	enum HealSpellType {
//		HEALTH, STRESS;
//	}
}
