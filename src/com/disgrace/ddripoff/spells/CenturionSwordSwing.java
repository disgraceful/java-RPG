package com.disgrace.ddripoff.spells;

import java.util.ArrayList;

import com.disgrace.ddripoff.heroes.HeroClass;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class CenturionSwordSwing extends DamageSpell{

	public CenturionSwordSwing(){
		initSpell();
	}
	
	@Override
	public void initSpell() {
		restrictionClass = HeroClass.CENTURION;
		damageType = DamageType.PHYS;
		range = RangeType.MELEE;
		spellType = TargetType.ENEMY;
		abilityStats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.ACC_MOD, 70, 100));
				add(new Stat(StatEnumeration.DAMAGE_MOD, 100, 100));
				add(new Stat(StatEnumeration.CRIT_MOD, 5, 100));
			}
		});

		callerRestrictedPos.add(0);
		callerRestrictedPos.add(1);

		targetsRestrictedPos.add(0);
		targetsRestrictedPos.add(1);
		
	}
}
