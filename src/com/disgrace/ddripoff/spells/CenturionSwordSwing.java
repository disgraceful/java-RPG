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
		name = "Sword Swing";
		description = "Cool description";
		restrictionClass = HeroClass.CENTURION;
		damageType = DamageType.PHYS;
		range = RangeType.MELEE;
		spellClass = SpellEnum.CENTURION_SWORD_SWING;
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
