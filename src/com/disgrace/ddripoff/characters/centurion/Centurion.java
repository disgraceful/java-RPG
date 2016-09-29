package com.disgrace.ddripoff.characters.centurion;

import java.util.ArrayList;

import com.disgrace.ddripoff.characters.Hero;
import com.disgrace.ddripoff.characters.HeroClass;
import com.disgrace.ddripoff.characters.Stat;
import com.disgrace.ddripoff.characters.StatEnumeration;
import com.disgrace.ddripoff.characters.StatWrapper;
import com.disgrace.ddripoff.characters.centurion.abilities.SwordSwing;

public class Centurion extends Hero {

	public Centurion(String name) {
		super(name);
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
