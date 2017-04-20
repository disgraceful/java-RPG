package com.disgrace.ddripoff.spells.instance;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.spells.AttackType;
import com.disgrace.ddripoff.spells.DamageType;
import com.disgrace.ddripoff.spells.OffensiveSpell;
import com.disgrace.ddripoff.spells.SpellOrientation;
import com.disgrace.ddripoff.spells.SpellPositionWrapper;
import com.disgrace.ddripoff.spells.SpellTargetQuantity;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

@XmlRootElement
public class CenturionSwordSwing extends OffensiveSpell {

	public CenturionSwordSwing() {
		name = "Sword Swing";
		description = "Centurion swings his sword in one devastating hit!";
		orientation = SpellOrientation.OFFENSIVE;
		attackType = AttackType.MELEE;
		damageType = DamageType.PHYSICAL;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnumeration.DAMAGE_MOD, 0), new Stat(StatEnumeration.ACC, 70),
				new Stat(StatEnumeration.CRIT_MOD, 5));
		callerRequiredPos = new SpellPositionWrapper(0, 1);
		targetRequiredPos = new SpellPositionWrapper(0, 1);
	}

	@Override
	public void initSpell() {
		
	}
}
