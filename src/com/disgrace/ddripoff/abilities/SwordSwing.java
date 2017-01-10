package com.disgrace.ddripoff.abilities;

import java.util.ArrayList;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.heroes.HeroClass;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;;

public class SwordSwing extends DamageAbility {

	public SwordSwing() {
		initAbility();
	}

	@Override
	public void useAbility(Character[] targets, Character caller) {
		super.useAbility(targets, caller);
	}

	@Override
	protected void initAbility() {
		name = "Sword Swing";
		description = "Cool description";
		restrictionClass = HeroClass.CENTURION;
		dmgType = DamageType.PHYS;
		rangeType = RangeType.MELEE;
		abilityStats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.ACC_MOD, 70, 100));
				add(new Stat(StatEnumeration.DAMAGE_MOD, 100, 100));
				add(new Stat(StatEnumeration.CRIT_MOD, 5, 100));
			}
		});

		callerRestrictedPos.add(new Integer(1));
		callerRestrictedPos.add(new Integer(2));

		targetsRestrictedPos.add(new Integer(1));
		targetsRestrictedPos.add(new Integer(2));
	}
}
