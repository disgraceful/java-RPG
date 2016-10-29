package com.disgrace.ddripoff.items;

import java.util.ArrayList;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatWrapper;

public class Trinket extends Item {
	private StatWrapper affectedstats;

	public Trinket(String name, ArrayList<Stat> affectedstats) {
		setName(name);
		this.affectedstats = new StatWrapper(affectedstats);
	}

	public StatWrapper getStatWrapper() {
		return affectedstats;
	}

	public boolean tryEquip(StatWrapper herostat) {
		// if(hero.class!=restriction||restriction != all)
		// return false;
		herostat.updateStats(affectedstats);
		System.out.println(herostat.getOwner().getName() + " has equipped " + this.getName());
		return true;
	}

	public boolean tryUnEquip(StatWrapper herostat) {
		if(herostat.getOwner()!=null){
		StatWrapper.reverseStatsValue(affectedstats);
		herostat.updateStats(affectedstats);
		System.out.println(herostat.getOwner().getName() + " has unequipped " + this.getName());
		return true;
		}
		else
			return false;

	}

}
