package com.disgrace.ddripoff.spells;

import java.util.ArrayList;

import com.disgrace.ddripoff.characters.heroes.HeroClass;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class CenturionShieldSlamMove extends MoveSpell {
	public CenturionShieldSlamMove() {
		initSpell();
	}

	@Override
	public void initSpell() {
		restrictionClass = HeroClass.CENTURION;
		range = RangeType.MELEE;
		spellOrientation = TargetType.ENEMY;
		abilityStats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.MOVE_CHANCE, 100, 220));
				add(new Stat(StatEnumeration.MOVE_SPELL_POSITION, 1, 3));
			}
		});

		callerRestrictedPos.add(0);

		targetsRestrictedPos.add(0);
		targetsRestrictedPos.add(1);
	}
}