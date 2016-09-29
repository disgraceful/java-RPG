package com.disgrace.ddripoff.characters;

import java.util.ArrayList;

import com.disgrace.ddripoff.abilities.Ability;

public class Hero extends Character {
	
	protected HeroClass heroClass;
	private ArrayList<Trinket> inventory = new ArrayList<Trinket>();
	private ArrayList<Ability> learnedAbilities = new ArrayList<Ability>();

	public Hero(String name) {
		super(name);
	}

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

	public ArrayList<Trinket> getItems() {
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

	public void useAbility(Ability ability, StatWrapper[] targets) {
		if (ifAbilityLearned(ability)) {
			ability.useAbility(targets, this.getStatWrapper());
		}
	}
}
