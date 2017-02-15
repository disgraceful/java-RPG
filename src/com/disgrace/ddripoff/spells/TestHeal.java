package com.disgrace.ddripoff.spells;

import java.util.ArrayList;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class TestHeal extends HealSpell {
	public TestHeal(){
		initSpell();
	}
	
	@Override
	public void initSpell() {
		healingStat = HealSpellType.HEALTH;
		range = RangeType.RANGE;
		spellOrientation = TargetType.ALLY;
		abilityStats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.HEALTH,10,true));
				add(new Stat(StatEnumeration.ACC_MOD, 75, 100));
				add(new Stat(StatEnumeration.CRIT_MOD, 0, 100));
			}
		});

		callerRestrictedPos.add(0);
		callerRestrictedPos.add(1);
		callerRestrictedPos.add(2);
		callerRestrictedPos.add(3);

		targetsRestrictedPos.add(0);
		targetsRestrictedPos.add(1);
		targetsRestrictedPos.add(2);
		targetsRestrictedPos.add(3);
	}
}
