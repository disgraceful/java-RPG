package com.disgrace.ddripoff.items;

import com.disgrace.ddripoff.characters.heroes.Hero;
import com.disgrace.ddripoff.characters.heroes.HeroClass;
import com.disgrace.ddripoff.stats.StatWrapper;

public abstract class Trinket extends Loot {
	protected StatWrapper affectedstats;
	protected HeroClass restriction;
	protected TrinketRarity itemRarity;

	public StatWrapper getStatWrapper() {
		return affectedstats;
	}

	public boolean tryEquipItem(Hero hero) {
		if (restriction != null && hero.getHeroClass() != restriction) {
			System.out.println("Failed to equip");
			return false;
		}
		hero.updateStats(affectedstats);
		System.out.println(hero.getName() + " has equipped " + this.getName());
		return true;
	}

	public void unequipItem(Hero hero) {
		hero.updateStats(StatWrapper.reverseStats(affectedstats));
		System.out.println(hero.getName() + " has unequipped " + this.getName());
	}
	
	protected abstract void initTrinket();
}
