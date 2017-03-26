package com.disgrace.ddripoff.characters.enemies;

import java.util.ArrayList;

import com.disgrace.ddripoff.spells.SpellEnum;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class OutcastCrossbowman extends Enemy {

	public OutcastCrossbowman() {
		name = "Outcast Crossbowman";
		init();
	}

	@Override
	protected void init() {
		eClass = EnemyClass.OUTCAST_CROSSBOWMAN;
		this.stats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.HEALTH, 15, 15));
				add(new Stat(StatEnumeration.DODGE, 7, 50));
				add(new Stat(StatEnumeration.PHYS_PROT, 0, 100));
				add(new Stat(StatEnumeration.DAMAGE, 9, 100));
				add(new Stat(StatEnumeration.SPEED, 6, 20));
				add(new Stat(StatEnumeration.ACC, 7, 100));
				add(new Stat(StatEnumeration.CRIT_CHANCE, 0, 100));
				add(new Stat(StatEnumeration.DEATH_RES, 0, 100));
			}
		});
		// allAbilities.add(SpellEnum.OUTCAST_SWORDSMAN_SLASH_OF_EXILE);
	}
}
