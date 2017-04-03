package com.disgrace.ddripoff.hub;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.characters.heroes.Hero;

@XmlRootElement
public class HeroRoster {
	private Set<Hero> heroSet = new HashSet<>();

	public void setHeroSet(Set<Hero> heroSet) {
		this.heroSet = heroSet;
	}

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
