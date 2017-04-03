package com.disgrace.ddripoff.hub;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.characters.heroes.Hero;
import com.disgrace.ddripoff.characters.heroes.HeroClass;
import com.disgrace.ddripoff.session.GameSession;
import com.disgrace.ddripoff.spawn.CharacterFactory;

@XmlRootElement
public class MercenaryCoach {
	private List<Hero> avaliableVenturers = new ArrayList<>();
	private int heroSpawnLimit = 3;

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
			avaliableVenturers.add(CharacterFactory.spawnRandomHero());
		}
	}
}
