package com.disgrace.ddripoff.spells;

import java.util.ArrayList;

import com.disgrace.ddripoff.characters.heroes.HeroClass;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class CenturionShieldSlamDamage extends DamageSpell {
	public CenturionShieldSlamDamage(){
		initSpell();
	}
	
	@Override
	public void initSpell() {
		restrictionClass = HeroClass.CENTURION;
		damageType = DamageType.PHYSICAL;
		range = RangeType.MELEE;
		spellOrientation = TargetType.ENEMY;
		abilityStats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.ACC_MOD, 75, 100));
				add(new Stat(StatEnumeration.DAMAGE_MOD, 40, 100));
				add(new Stat(StatEnumeration.CRIT_MOD, 0, 100));
			}
		});

		callerRestrictedPos.add(0);

		targetsRestrictedPos.add(0);
		targetsRestrictedPos.add(1);
	}
}

