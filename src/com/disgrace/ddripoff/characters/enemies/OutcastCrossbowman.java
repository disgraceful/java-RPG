package com.disgrace.ddripoff.characters.enemies;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;
@XmlRootElement
public class OutcastCrossbowman extends Enemy {

	public OutcastCrossbowman() {
		name = "Outcast Crossbowman";
		eClass = EnemyClass.OUTCAST_CROSSBOWMAN;
		this.stats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.HEALTH, 10, 10));
				add(new Stat(StatEnumeration.DODGE, 9, 50));
				add(new Stat(StatEnumeration.PHYS_PROT, 0, 100));
				add(new Stat(StatEnumeration.DAMAGE, 9, 100));
				add(new Stat(StatEnumeration.SPEED, 4, 20));
				add(new Stat(StatEnumeration.ACC, 7, 100));
				add(new Stat(StatEnumeration.CRIT_CHANCE, 0, 100));
				
				add(new Stat(StatEnumeration.DEATH_RES, 66, 100));
				add(new Stat(StatEnumeration.MOVE_RES, 50, 220));
				add(new Stat(StatEnumeration.BLEED_RES, 40, 220));
				add(new Stat(StatEnumeration.BLIGHT_RES, 30, 220));
				add(new Stat(StatEnumeration.DEBUFF_RES, 30, 220));
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
		 
	}
}
