package com.disgrace.ddripoff.characters.heroes;

import java.util.ArrayList;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class Purifier extends Hero {

	public Purifier() {
		name = "Centurion";
		init();
	}
	
	@Override
	protected void init(){
		this.heroClass = HeroClass.PURFIER;
		this.stats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.HEALTH, 19,19));
				add(new Stat(StatEnumeration.DODGE, 5,50));
				add(new Stat(StatEnumeration.PHYS_PROT, 5, 100));
				add(new Stat(StatEnumeration.DAMAGE, 9, 100));
				add(new Stat(StatEnumeration.SPEED, 4, 20));
				add(new Stat(StatEnumeration.ACC, 5, 100));
				add(new Stat(StatEnumeration.CRIT_CHANCE, 5, 100));
				add(new Stat(StatEnumeration.DEATH_RES, 66, 100));
			}
		});
		//allAbilities.add(SpellEnum.CENTURION_SWORD_SWING);
		
	}

}
