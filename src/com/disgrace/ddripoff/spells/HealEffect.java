package com.disgrace.ddripoff.spells;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.utils.CalculationHelper;

@XmlRootElement
public class HealEffect extends Effect implements Serializable {

	@Override
	public void applyEffect(Character caller, Character target) {
	
		target.updateStats(calcHeal());
	}

	private Stat calcHeal() {
		
		double healValue = getEffectStats().getStatbyName(StatEnumeration.HEALTH).getCurValue();
		healValue = CalculationHelper.calcRandomIntWithPercent((int) healValue, SpellConstants.CALC_DISPERSION_30);
		return new Stat(StatEnumeration.HEALTH, (int) healValue);
	}

}
