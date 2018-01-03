package rpg.core.hub;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import rpg.core.characters.heroes.Hero;


public class HeroRoster {
	private List<Hero> heroes = new ArrayList<>();

	public void setHeroes(List<Hero> heroes) {
		this.heroes = heroes;
	}

	public List<Hero> getHeroes() {
		return heroes;
	}
	
	public void hireHero(Hero hero){
		heroes.add(hero);
	}
	
	public void dismissHero(Hero hero){
		heroes.remove(hero);
	}

}
