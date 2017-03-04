package com.disgrace.ddripoff.items;

import java.util.ArrayList;

import com.disgrace.ddripoff.characters.shared.Character;
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

	public boolean tryEquip(Character hero) {
		// if(hero.class!=restriction||restriction != all)
		// return false;
		hero.getStats().updateStats(affectedstats);
		System.out.println(hero.getName() + " has equipped " + this.getName());
		return true;
	}

	public boolean tryUnEquip(Character hero) {
		if (hero != null) {

			hero.getStats().updateStats(StatWrapper.reverseStats(affectedstats));
			// System.out.println(hero.getOwner().getName() + " has unequipped "
			// + this.getName());
			return true;
		} else
			return false;

	}

}
