package com.disgrace.ddripoff.characters.heroes;

import java.util.ArrayList;

import com.disgrace.ddripoff.spells.SpellEnum;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class Dishonored extends Hero {

	public Dishonored() {
		name = "Dishonored";
		init();
	}
			
	@Override
	protected void init(){
		this.heroClass = HeroClass.DISHONORED;
		this.stats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.HEALTH, 21,21));
				add(new Stat(StatEnumeration.STRESS, 0,200));
				add(new Stat(StatEnumeration.DODGE, 7,50));
				add(new Stat(StatEnumeration.MAG_PROT, 0,100));
				add(new Stat(StatEnumeration.PHYS_PROT, 0, 100));
				add(new Stat(StatEnumeration.STRESS_PROT, 0,100));
				add(new Stat(StatEnumeration.DAMAGE, 10, 100));
				add(new Stat(StatEnumeration.SPEED, 6, 20));
				add(new Stat(StatEnumeration.ACC, 0, 100));
				add(new Stat(StatEnumeration.CRIT_CHANCE, 5, 100));
				add(new Stat(StatEnumeration.STUN_RES, 50, 100));
				add(new Stat(StatEnumeration.BLIGHT_RES, 30, 100));
				add(new Stat(StatEnumeration.DISIEASE_RES, 20, 100));
				add(new Stat(StatEnumeration.DEATH_RES, 66, 100));
				add(new Stat(StatEnumeration.MOVE_RES, 50, 100));
				add(new Stat(StatEnumeration.BLEED_RES, 40, 100));
				add(new Stat(StatEnumeration.DEBUFF_RES, 20, 100));
				add(new Stat(StatEnumeration.TRAP_DISARM_CHANCE, 70, 100));
				//ability related
				add(new Stat(StatEnumeration.STUN_CHANCE, 0, 100));
				//status stat
				add(new Stat(StatEnumeration.IS_STUNNED, 0, 1));
			}
		});
		//allAbilities.add(SpellEnum.CENTURION_SWORD_SWING);
		
	}

}