package com.disgrace.ddripoff.locations.hub;

import java.util.ArrayList;
import java.util.Random;

import com.disgrace.ddripoff.characters.Hero;
import com.disgrace.ddripoff.characters.HeroClass;
import com.disgrace.ddripoff.locations.Location;

public class VenturerCoach implements Location  {
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
			Hero.generateHero(s);
		}
	}
	
	
}
