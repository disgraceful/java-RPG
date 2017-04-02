package com.disgrace.ddripoff.characters.heroes;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.spells.TestDamage;
import com.disgrace.ddripoff.spells.TestDamage2;
import com.disgrace.ddripoff.spells.TestUtility;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;
@XmlRootElement
public class UberHeroTest extends Hero {

	public UberHeroTest(String name) {
		this.name = name;
		init();
	}

	@Override
	protected void init() {
		this.heroClass = HeroClass.CENTURION;
		this.stats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.HEALTH, 30, 30));
				add(new Stat(StatEnumeration.PHYS_PROT, 5, 99));
				add(new Stat(StatEnumeration.DAMAGE, 7, 99));
				add(new Stat(StatEnumeration.DODGE, 4, 99));
				add(new Stat(StatEnumeration.SPEED, 4, 99));
				add(new Stat(StatEnumeration.ACC_MOD, 0, 99));
				add(new Stat(StatEnumeration.CRIT_CHANCE, 5, 99));
				
				add(new Stat(StatEnumeration.DEATH_RES, 66, 100));
				add(new Stat(StatEnumeration.MOVE_RES, 50, 220));
				add(new Stat(StatEnumeration.BLEED_RES, 50, 220));
				add(new Stat(StatEnumeration.BLIGHT_RES, 50, 220));
				add(new Stat(StatEnumeration.DEBUFF_RES, 50, 220));
				add(new Stat(StatEnumeration.STUN_RES, 50, 220));
				
				add(new Stat(StatEnumeration.RANGE_MOD, 0, 100));
				add(new Stat(StatEnumeration.MELEE_MOD, 0, 100));
				add(new Stat(StatEnumeration.PHYS_MOD, 0, 100));
				
				add(new Stat(StatEnumeration.MOVE_CHANCE, 0, 220));
				add(new Stat(StatEnumeration.BLIGHT_CHANCE, 0, 220));
				add(new Stat(StatEnumeration.BLEED_CHANCE, 0, 220));
				add(new Stat(StatEnumeration.STUN_CHANCE, 0, 220));
				add(new Stat(StatEnumeration.DEBUFF_CHANCE, 0, 220));
			}
		});
		allAbilities.add(new TestDamage());
		allAbilities.add(new TestDamage2());
		allAbilities.add(new TestUtility());
	}
}