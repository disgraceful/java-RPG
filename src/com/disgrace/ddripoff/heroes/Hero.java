package com.disgrace.ddripoff.heroes;

import java.util.ArrayList;
import java.util.List;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.items.Trinket;
import com.disgrace.ddripoff.spells.SpellEnum;

public abstract class Hero extends Character{
	protected HeroClass heroClass;
	private List<Trinket> inventory = new ArrayList<Trinket>();
	private List<SpellEnum> learnedAbilities = new ArrayList<SpellEnum>();

	public void equip(Trinket trinket) {
		if (trinket.tryEquip(this)) {
			inventory.add(trinket);
		}
	}

	public boolean ifTrinketEquiped(Trinket trinket) {
		return inventory.contains(trinket);
	}

	public void unequip(Trinket trinket) {
		if (ifTrinketEquiped(trinket) && trinket.tryUnEquip(this)) {
			inventory.remove(trinket);
		}
	}

	public List<Trinket> getItems() {
		return inventory;
	}

	private boolean ifAbilityLearned(SpellEnum ability) {
		return learnedAbilities.contains(ability);
	}

	public void learnAbility(SpellEnum ability) {
		if (allAbilities.contains(ability)) {
			learnedAbilities.add(ability);
		}
	}
	
	@Override
	public void useAbility(SpellEnum ability, Character[] targets) {
		//if (ifAbilityLearned(ability)) {
			ability.castSpellCombo(targets, this);
		
	}
}
