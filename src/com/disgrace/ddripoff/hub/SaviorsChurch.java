package com.disgrace.ddripoff.hub;

import java.util.ArrayList;

import com.disgrace.ddripoff.heroes.Hero;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class SaviorsChurch {

	public void relief(Hero hero, ChurchRelieves relief){
		StatWrapper s = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.STRESS, -relief.getStress(), 100));
			}
		});
		hero.getStatWrapper().updateStats(s);
		//-remove the cost 	
	}
}
