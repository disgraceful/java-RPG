package com.disgrace.ddripoff.heroes;

import java.util.ArrayList;

import com.disgrace.ddripoff.spawn.SpawnableEnemy;
import com.disgrace.ddripoff.spells.SpellEnum;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class Centurion extends Hero implements SpawnableEnemy{

	public Centurion() {
		name = "Default";
		init();
	}
	
	@Override
	protected void init(){
		this.heroClass = HeroClass.CENTURION;
		this.stats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.HEALTH, 30,30));
				add(new Stat(StatEnumeration.STRESS, 0,200));
				add(new Stat(StatEnumeration.DODGE, 4,50));
				add(new Stat(StatEnumeration.MAG_PROT, 0,100));
				add(new Stat(StatEnumeration.PHYS_PROT, 5, 100));
				add(new Stat(StatEnumeration.STRESS_PROT, 0,100));
				add(new Stat(StatEnumeration.DAMAGE, 7, 100));
				add(new Stat(StatEnumeration.SPEED, 4, 20));
				add(new Stat(StatEnumeration.ACC, 5, 100));
				add(new Stat(StatEnumeration.CRIT_CHANCE, 5, 100));
				add(new Stat(StatEnumeration.STUN_RES, 50, 100));
				add(new Stat(StatEnumeration.BLIGHT_RES, 30, 100));
				add(new Stat(StatEnumeration.DISIEASE_RES, 30, 100));
				add(new Stat(StatEnumeration.DEATH_RES, 66, 100));
				add(new Stat(StatEnumeration.MOVE_RES, 50, 100));
				add(new Stat(StatEnumeration.BLEED_RES, 40, 100));
				add(new Stat(StatEnumeration.DEBUFF_RES, 30, 100));
				add(new Stat(StatEnumeration.TRAP_DISARM_CHANCE, 10, 100));
			}
		});
		
	}

	@Override
	public SpawnableEnemy spawn() {
		return new Centurion();
	}
}
