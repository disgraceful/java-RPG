package com.disgrace.ddripoff.spells.instance;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.spells.AttackType;
import com.disgrace.ddripoff.spells.DamageType;
import com.disgrace.ddripoff.spells.Move;
import com.disgrace.ddripoff.spells.OffensiveSpell;
import com.disgrace.ddripoff.spells.SpellOrientation;
import com.disgrace.ddripoff.spells.SpellPositionWrapper;
import com.disgrace.ddripoff.spells.SpellTargetQuantity;
import com.disgrace.ddripoff.spells.Stun;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

@XmlRootElement
public class CenturionShieldSlam extends OffensiveSpell {

	public CenturionShieldSlam() {
		name = "Shield Slam";
		description = "Centurion slams his sword stunning and knocking enemy back!";
		orientation = SpellOrientation.OFFENSIVE;
		attackType = AttackType.MELEE;
		damageType = DamageType.PHYSICAL;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnumeration.DAMAGE_MOD, -40), new Stat(StatEnumeration.ACC, 75),
				new Stat(StatEnumeration.CRIT_MOD, 0));
		applyingEffects.add(new Stun(new StatWrapper(new Stat(StatEnumeration.STUN_CHANCE, 110))));
		applyingEffects.add(new Move(new StatWrapper(new Stat(StatEnumeration.MOVE_CHANCE, 100),
				new Stat(StatEnumeration.MOVE_SPELL_POSITION, -1))));
		callerRequiredPos = new SpellPositionWrapper(1);
		targetRequiredPos = new SpellPositionWrapper(0, 1);
	}

	@Override
	public void initSpell() {
	

	}

}
