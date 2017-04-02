package com.disgrace.ddripoff.characters.heroes;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;
@XmlRootElement
public class Priest extends Hero {

	public Priest() {
		name = "Priest";
		init();
	}

	@Override
	protected void init() {
		this.heroClass = HeroClass.PRIEST;
		this.stats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.HEALTH, 16, 16));
				add(new Stat(StatEnumeration.DODGE, 6, 50));
				add(new Stat(StatEnumeration.PHYS_PROT, 5, 100));
				add(new Stat(StatEnumeration.DAMAGE, 4, 100));
				add(new Stat(StatEnumeration.SPEED, 5, 20));
				add(new Stat(StatEnumeration.ACC, 0, 100));
				add(new Stat(StatEnumeration.CRIT_CHANCE, 5, 100));
				add(new Stat(StatEnumeration.DEATH_RES, 66, 100));
			}
		});
		// allAbilities.add(SpellEnum.CENTURION_SWORD_SWING);

	}
}
