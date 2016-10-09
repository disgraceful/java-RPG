package com.disgrace.ddripoff.locations.hub;

import java.util.ArrayList;

import com.disgrace.ddripoff.characters.heroes.Hero;
import com.disgrace.ddripoff.characters.stats.Stat;
import com.disgrace.ddripoff.characters.stats.StatEnumeration;
import com.disgrace.ddripoff.characters.stats.StatWrapper;
import com.disgrace.ddripoff.locations.Location;

public class SaviorsChurch implements Location {

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
