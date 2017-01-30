package com.disgrace.ddripoff.hub;

import java.util.ArrayList;

import com.disgrace.ddripoff.characters.heroes.Hero;
import com.disgrace.ddripoff.characters.heroes.HeroClass;

public class VenturerCoach {
	private ArrayList<Hero> avaliableVenturers = new ArrayList<Hero>();
	static int ROSTER_CAP=8;
	private int heroSpawnLimit = 3;
	
	
	public ArrayList<Hero>getVenturers(){
		return avaliableVenturers;
	}
	
	public void recruit(Hero hero){
		//add to actual roster
		avaliableVenturers.remove(hero);
	}
	
	public void spawnVenturers(){
		for (int i = 0; i < ROSTER_CAP; i++) {
			HeroClass s = HeroClass.getRandomValue();
			//Hero.generateHero(s);
		}
	}
	
	
}
