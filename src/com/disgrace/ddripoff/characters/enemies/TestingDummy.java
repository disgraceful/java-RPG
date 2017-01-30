package com.disgrace.ddripoff.characters.enemies;

import java.util.ArrayList;

import com.disgrace.ddripoff.spells.SpellEnum;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class TestingDummy extends Enemy {
	public TestingDummy() {
		name = "Dummy";
		init();
	}

	@Override
	protected void init() {
		eClass = EnemyClass.TESTING_DUMMY;
		this.stats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.HEALTH, 1000, 1000));
				add(new Stat(StatEnumeration.DODGE, 0, 50));
				add(new Stat(StatEnumeration.MAG_PROT, 0, 100));
				add(new Stat(StatEnumeration.PHYS_PROT, 0, 100));
				add(new Stat(StatEnumeration.DAMAGE, 0, 100));
				add(new Stat(StatEnumeration.SPEED, 1, 20));
				add(new Stat(StatEnumeration.ACC, 0, 100));
				add(new Stat(StatEnumeration.CRIT_CHANCE, 0, 100));
				add(new Stat(StatEnumeration.STUN_RES, 0, 100));
				add(new Stat(StatEnumeration.BLIGHT_RES, 0, 100));
				add(new Stat(StatEnumeration.DEATH_RES, 99, 100));
				add(new Stat(StatEnumeration.MOVE_RES, 0, 100));
				add(new Stat(StatEnumeration.BLEED_RES, 0, 100));
				add(new Stat(StatEnumeration.DEBUFF_RES, 0, 100));
				//status stat
				add(new Stat(StatEnumeration.IS_STUNNED, 0, 1));
			}
		});
		
	}
}
