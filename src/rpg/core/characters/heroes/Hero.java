package rpg.core.characters.heroes;

import java.util.ArrayList;
import java.util.List;

import rpg.core.characters.shared.Character;
import rpg.core.items.trinkets.Trinket;
import rpg.core.spells.Spell;;

public abstract class Hero extends Character {
	protected HeroClass heroClass;
	protected List<Trinket> inventory = new ArrayList<>();
	protected List<Spell> learnedAbilities = new ArrayList<>();

	protected TraitsWrapper traitsWrapper;

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
	public Class<Hero> getCharClass() {
		return Hero.class;
	}

	public HeroClass getHeroClass() {
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
		if (ifTrinketEquiped(trinket)) {
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
		// if (ifAbilityLearned(ability)) {
		ability.useSpell(this, targets);
	}

}
