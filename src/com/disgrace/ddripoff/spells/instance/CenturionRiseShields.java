package com.disgrace.ddripoff.spells.instance;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.spells.Buff;
import com.disgrace.ddripoff.spells.SpellOrientation;
import com.disgrace.ddripoff.spells.SpellPositionWrapper;
import com.disgrace.ddripoff.spells.SpellTargetQuantity;
import com.disgrace.ddripoff.spells.UtilitySpell;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

@XmlRootElement
public class CenturionRiseShields extends UtilitySpell {
	public CenturionRiseShields() {
		name = "Rise Shields";
		description = "Centurion commands his men to take deffensive formation!";
		targetQuantity = SpellTargetQuantity.MULTIPLE;
		orientation = SpellOrientation.UTILITY;
		applyingEffects.add(new Buff(4, new StatWrapper(new Stat(StatEnumeration.PHYS_PROT, 10, false))));
		selfApplyingEffects.add(new Buff(4, new StatWrapper(new Stat(StatEnumeration.PHYS_PROT, 10, false))));
		callerRequiredPos = new SpellPositionWrapper(0);
		targetRequiredPos = new SpellPositionWrapper(0, 1, 2, 3);
	}

	
}
