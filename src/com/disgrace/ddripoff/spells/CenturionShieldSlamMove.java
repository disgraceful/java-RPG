package com.disgrace.ddripoff.spells;

import java.util.ArrayList;

import com.disgrace.ddripoff.heroes.HeroClass;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class CenturionShieldSlamMove extends MoveSpell {
	public CenturionShieldSlamMove() {
		initSpell();
	}

	@Override
	public void initSpell() {
		name = "Shield Slam";
		description = "Cool description";
		restrictionClass = HeroClass.CENTURION;
		range = RangeType.MELEE;

		abilityStats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.MOVE_CHANCE, 100, 220));
				add(new Stat(StatEnumeration.MOVE_SPELL_POSITION, 1, 3));
			}
		});

		callerRestrictedPos.add(new Integer(1));

		targetsRestrictedPos.add(new Integer(1));
		targetsRestrictedPos.add(new Integer(2));
	}
}