package com.disgrace.ddripoff.hub;

import java.util.ArrayList;
import java.util.List;

import com.disgrace.ddripoff.characters.heroes.Hero;
import com.disgrace.ddripoff.characters.heroes.HeroClass;
import com.disgrace.ddripoff.session.GameSession;
import com.disgrace.ddripoff.spawn.CharacterFactory;

public class MercenaryCoach {
	private List<Hero> avaliableVenturers = new ArrayList<>();
	private int heroSpawnLimit = 3;
		
	public List<Hero>getVenturers(){
		return avaliableVenturers;
	}
	
	public void recruit(Hero hero){
		GameSession.getSession().hireHero(hero);
		avaliableVenturers.remove(hero);
	}
	
	public void spawnVenturers(){
		avaliableVenturers.clear();
		for (int i = 0; i < heroSpawnLimit; i++) {
			avaliableVenturers.add(CharacterFactory.spawnRandomHero());
		}
	}
}
