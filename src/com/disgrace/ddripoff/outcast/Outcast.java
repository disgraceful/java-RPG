package com.disgrace.ddripoff.outcast;

import java.util.ArrayList;

import com.disgrace.ddripoff.enemies.Enemy;
import com.disgrace.ddripoff.enemies.EnemyClass;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class Outcast extends Enemy {

	public Outcast() {
		name = "Default";
	}

	@Override
	protected void init() {
		this.enemyClass = EnemyClass.HUMAN; 
		this.stats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.HEALTH, 30, 30));
				add(new Stat(StatEnumeration.PHYSPROT, 5, 100));
				add(new Stat(StatEnumeration.DAMAGE, 7, 100));
				add(new Stat(StatEnumeration.SPEED, 4, 20));
			}
		});
		// allAbilities.addAll();
	}

}
