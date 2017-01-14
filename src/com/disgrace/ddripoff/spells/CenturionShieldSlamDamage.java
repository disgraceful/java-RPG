package com.disgrace.ddripoff.spells;

import java.util.ArrayList;

import com.disgrace.ddripoff.heroes.HeroClass;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class CenturionShieldSlamDamage extends DamageSpell {
	public CenturionShieldSlamDamage(){
		initSpell();
	}
	
	@Override
	public void initSpell() {
		name = "Shield Slam";
		description = "Cool description";
		restrictionClass = HeroClass.CENTURION;
		damageType = DamageType.PHYS;
		range = RangeType.MELEE;
		
		abilityStats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.ACC_MOD, 75, 100));
				add(new Stat(StatEnumeration.DAMAGE_MOD, 40, 100));
				add(new Stat(StatEnumeration.CRIT_MOD, 0, 100));
			}
		});

		callerRestrictedPos.add(new Integer(1));

		targetsRestrictedPos.add(new Integer(1));
		targetsRestrictedPos.add(new Integer(2));
	}
}

