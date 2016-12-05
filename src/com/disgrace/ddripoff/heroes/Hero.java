package com.disgrace.ddripoff.heroes;

import java.util.ArrayList;
import java.util.List;

import com.disgrace.ddripoff.abilities.Ability;
import com.disgrace.ddripoff.characters.Character;
import com.disgrace.ddripoff.items.Trinket;
import com.disgrace.ddripoff.stats.StatWrapper;

public abstract class Hero extends Character{
	protected HeroClass heroClass;
	private List<Trinket> inventory = new ArrayList<Trinket>();
	private List<Ability> learnedAbilities = new ArrayList<Ability>();

	public void equip(Trinket trinket) {
		if (trinket.tryEquip(this.getStatWrapper())) {
			inventory.add(trinket);
		}
	}

	public boolean ifTrinketEquiped(Trinket trinket) {
		return inventory.contains(trinket);
	}

	public void unequip(Trinket trinket) {
		if (ifTrinketEquiped(trinket) && trinket.tryUnEquip(this.getStatWrapper())) {
			inventory.remove(trinket);
		}
	}

	public List<Trinket> getItems() {
		return inventory;
	}

	private boolean ifAbilityLearned(Ability ability) {
		return learnedAbilities.contains(ability);
	}

	public void learnAbility(Ability ability) {
		if (allAbilities.contains(ability)) {
			learnedAbilities.add(ability);
			System.out.println(this.getName() + " has learned " + ability.getName());
		}
	}

	public void useAbility(Ability ability, Character[] targets) {
		if (ifAbilityLearned(ability)) {
			ability.useAbility(targets, this);
		}
	}
}
