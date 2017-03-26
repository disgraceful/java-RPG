package com.disgrace.ddripoff.characters.heroes;

import java.util.HashSet;
import java.util.Set;

public class HeroRoster {
	private Set<Hero> heroSet = new HashSet<>();

	public Set<Hero> getHeroSet() {
		return heroSet;
	}
	
	public void hireHero(Hero hero){
		heroSet.add(hero);
	}
	
	public void dismissHero(Hero hero){
		heroSet.remove(hero);
	}

}
