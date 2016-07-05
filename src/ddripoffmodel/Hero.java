package ddripoffmodel;

import java.util.ArrayList;

public class Hero extends Character {

	//private final HeroClass heroClass;
	public Hero(String name, ArrayList<Stat> stat) {
		super(name, stat);
	}

	private ArrayList<Trinket> inventory = new ArrayList<Trinket>();
	private ArrayList<Ability> abilities = new ArrayList<Ability>();

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

	public boolean ifAbilityLearned(Ability ability) {
		return abilities.contains(ability);
	}

	public void learnAbility(Ability ability) {
		// if(hero.lvl>ability.requiredlvl)
		abilities.add(ability);
		System.out.println(this.getName() + " has learned " + ability.getName());
	}

	public void useAbility(Ability ability, StatWrapper[] targets) {
		if (ifAbilityLearned(ability)) {
			ability.useAbility(targets, this.getStatWrapper());
		}
	}

	public ArrayList<Trinket> getItems() {
		return inventory;
	}

	public ArrayList<Ability> getAbilities() {
		return abilities;
	}

	
}
