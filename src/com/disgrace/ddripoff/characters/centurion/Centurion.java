package com.disgrace.ddripoff.characters.centurion;

import java.util.ArrayList;

import com.disgrace.ddripoff.characters.Hero;
import com.disgrace.ddripoff.characters.HeroClass;
import com.disgrace.ddripoff.characters.stats.Stat;
import com.disgrace.ddripoff.characters.stats.StatEnumeration;
import com.disgrace.ddripoff.characters.stats.StatWrapper;

public class Centurion extends Hero {

	public Centurion() {
		name = "Default";
		initHero();
	}
	
	private void initHero(){
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
