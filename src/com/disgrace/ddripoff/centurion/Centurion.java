package com.disgrace.ddripoff.centurion;

import java.util.ArrayList;

import com.disgrace.ddripoff.heroes.Hero;
import com.disgrace.ddripoff.heroes.HeroClass;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class Centurion extends Hero {

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
				add(new Stat(StatEnumeration.PHYSPROT, 5, 100));
				add(new Stat(StatEnumeration.DAMAGE, 7, 100));
				add(new Stat(StatEnumeration.SPEED, 4, 20));
			}
		});
		//allAbilities.addAll(new SwordSwing());
	}
}