package com.disgrace.ddripoff.items;

import java.util.ArrayList;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatWrapper;
import com.disgrace.ddripoff.characters.Character;


public class Trinket extends Item {
	private StatWrapper affectedstats;

	public Trinket(String name, ArrayList<Stat> affectedstats) {
		setName(name);
		this.affectedstats = new StatWrapper(affectedstats);
	}

	public StatWrapper getStatWrapper() {
		return affectedstats;
	}

	public boolean tryEquip(Character hero) {
		// if(hero.class!=restriction||restriction != all)
		// return false;
		hero.getStats().updateStats(affectedstats);
		System.out.println(hero.getName() + " has equipped " + this.getName());
		return true;
	}

	public boolean tryUnEquip(Character hero) {
		if(hero!=null){
		StatWrapper.reverseStatsValue(affectedstats);
		hero.getStats().updateStats(affectedstats);
		//System.out.println(hero.getOwner().getName() + " has unequipped " + this.getName());
		return true;
		}
		else
			return false;

	}

}
