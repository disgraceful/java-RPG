package com.disgrace.ddripoff.spells;

import java.util.ArrayList;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.heroes.HeroClass;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class CenturionShieldSlam extends DamageSpell {
	public CenturionShieldSlam(){
		initSpell();
	}
	
	@Override
	public void useSpell(Character[] targets, Character caller) {
		super.useSpell(targets, caller);
		
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
				add(new Stat(StatEnumeration.STUN_CHANCE,110,220));
				add(new Stat(StatEnumeration.MOVE_CHANCE,100,220));
				add(new Stat(StatEnumeration.MOVE_SPELL_POSITION,1,3));
			}
		});

		callerRestrictedPos.add(new Integer(1));

		targetsRestrictedPos.add(new Integer(1));
		targetsRestrictedPos.add(new Integer(2));
	}
}
