package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.utils.CalculationHelper;

public abstract class HealSpell extends Spell {

	protected HealSpellType healingStat;
	
	@Override
	public void useSpell(Character[] targets, Character caller) {
		for (Character target : targets) {
			int healValue = calcHealValue(getProperBaseValue());
			if (criticalStrike(target, caller)) {
				healValue *= 1.25;
			}
			getProperStatWrapper(healValue);
			target.updateStats(affectedStats);
		}
	}
	
	private int calcHealValue(int baseValue){
		return CalculationHelper.calcRandomIntWithPercent(baseValue, 0.25);
	}
	
	private int getProperBaseValue(){
		return healingStat==HealSpellType.HEALTH?affectedStats.getStatbyName(StatEnumeration.HEALTH).getCurValue():affectedStats.getStatbyName(StatEnumeration.STRESS).getCurValue();
	}
	
	private void getProperStatWrapper(int value){
		 if(healingStat== HealSpellType.HEALTH){
			 affectedStats.getStatbyName(StatEnumeration.HEALTH).setValue(value);
		 }else{
			 affectedStats.getStatbyName(StatEnumeration.STRESS).setValue(value);
		 }
	}

	enum HealSpellType{
		HEALTH,STRESS;
	}
}
