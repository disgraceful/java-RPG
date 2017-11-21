package rpg.core.hub;

import java.util.ArrayList;
import java.util.List;

import rpg.core.characters.heroes.Hero;
import rpg.core.factories.CharacterFactory;
import rpg.core.session.GameSession;


public class MercenaryCoach {
	private List<Hero> avaliableVenturers = new ArrayList<>();
	private int heroSpawnLimit = 3;

	public MercenaryCoach() {//NOSONAR
	}
	
	public List<Hero> getAvaliableVenturers() {
		return avaliableVenturers;
	}

	public void setAvaliableVenturers(List<Hero> avaliableVenturers) {
		this.avaliableVenturers = avaliableVenturers;
	}

	public int getHeroSpawnLimit() {
		return heroSpawnLimit;
	}

	public void setHeroSpawnLimit(int heroSpawnLimit) {
		this.heroSpawnLimit = heroSpawnLimit;
	}

	public void recruit(Hero hero) {
		GameSession.getSessionInstance().hireHero(hero);
		avaliableVenturers.remove(hero);
	}

	public void spawnVenturers() {
		avaliableVenturers.clear();
		for (int i = 0; i < heroSpawnLimit; i++) {
			//avaliableVenturers.add(CharacterFactory.spawnRandomHero());
		}
	}
}
