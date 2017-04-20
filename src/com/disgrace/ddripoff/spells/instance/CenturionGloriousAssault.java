package com.disgrace.ddripoff.spells.instance;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.spells.AttackType;
import com.disgrace.ddripoff.spells.DamageType;
import com.disgrace.ddripoff.spells.Move;
import com.disgrace.ddripoff.spells.OffensiveSpell;
import com.disgrace.ddripoff.spells.SpellOrientation;
import com.disgrace.ddripoff.spells.SpellPositionWrapper;
import com.disgrace.ddripoff.spells.SpellTargetQuantity;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

@XmlRootElement
public class CenturionGloriousAssault extends OffensiveSpell  {

	public CenturionGloriousAssault() {
		name = "Glorious Assault";
		description = "Centurion swiftly rushes forward, striking the enemy!";
		orientation = SpellOrientation.OFFENSIVE;
		attackType = AttackType.MELEE;
		damageType = DamageType.PHYSICAL;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnumeration.DAMAGE_MOD, 10), new Stat(StatEnumeration.ACC, 65),
				new Stat(StatEnumeration.CRIT_MOD, 5));
		selfApplyingEffects.add(new Move(new StatWrapper(new Stat(StatEnumeration.MOVE_SPELL_POSITION, 2))));
		callerRequiredPos = new SpellPositionWrapper(0, 1,2);
		targetRequiredPos = new SpellPositionWrapper(0, 1,2);
	}

	@Override
	public void initSpell() {
		
	}
}
