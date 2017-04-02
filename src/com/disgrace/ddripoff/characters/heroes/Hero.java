package com.disgrace.ddripoff.characters.heroes;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.items.Trinket;
import com.disgrace.ddripoff.spells.Spell;
@XmlRootElement
public abstract class Hero extends Character{
	protected HeroClass heroClass;
	private List<Trinket> inventory = new ArrayList<>();
	private List<Spell> learnedAbilities = new ArrayList<>();
	
	public List<Trinket> getInventory() {
		return inventory;
	}

	public void setInventory(List<Trinket> inventory) {
		this.inventory = inventory;
	}

	public List<Spell> getLearnedAbilities() {
		return learnedAbilities;
	}

	public void setLearnedAbilities(List<Spell> learnedAbilities) {
		this.learnedAbilities = learnedAbilities;
	}

	public void setHeroClass(HeroClass heroClass) {
		this.heroClass = heroClass;
	}

	@Override
	public Class<Hero> getCharClass(){
		return Hero.class;
	}
	
	public HeroClass getHeroClass(){
		return heroClass;
	}
	
	public List<Trinket> getItems() {
		return inventory;
	}
	
	public void equip(Trinket trinket) {
		if (trinket.tryEquipItem(this)) {
			inventory.add(trinket);
		}
	}
	
	public boolean ifTrinketEquiped(Trinket trinket) {
		return inventory.contains(trinket);
	}

	public void unequip(Trinket trinket) {
		if (ifTrinketEquiped(trinket))  {
			trinket.unequipItem(this);
			inventory.remove(trinket);
		}
	}	

	private boolean ifAbilityLearned(Spell ability) {
		return learnedAbilities.contains(ability);
	}

	public void learnAbility(Spell ability) {
		if (allAbilities.contains(ability)) {
			learnedAbilities.add(ability);
		}
	}
	
	@Override
	public void useAbility(Spell ability, Character... targets) {
		//if (ifAbilityLearned(ability)) {
			ability.useSpell(this, targets);
	}
	
	
}
