package rpg.core.items;

import rpg.core.characters.heroes.Hero;
import rpg.core.characters.heroes.HeroClass;
import rpg.core.characters.shared.StatWrapper;

public abstract class Trinket extends Item {
	protected StatWrapper affectedstats;
	protected HeroClass restriction;
	protected TrinketRarity itemRarity;

	
	public StatWrapper getAffectedstats() {
		return affectedstats;
	}

	public void setAffectedstats(StatWrapper affectedstats) {
		this.affectedstats = affectedstats;
	}

	public HeroClass getRestriction() {
		return restriction;
	}

	public void setRestriction(HeroClass restriction) {
		this.restriction = restriction;
	}

	public TrinketRarity getItemRarity() {
		return itemRarity;
	}

	public void setItemRarity(TrinketRarity itemRarity) {
		this.itemRarity = itemRarity;
	}

	@Override
	public int getCost() {
		return itemRarity.getCost();
	}
	
	@Override
	public int getDropRate() {
		return itemRarity.getDropRate();
	}
	
	public TrinketRarity getRarity(){
		return itemRarity;
	}
	
	public StatWrapper getStatWrapper() {
		return affectedstats;
	}
	
	@Override
	protected void initItem() {
		maxSpawnQuanitity = 1;
		inventoryFitQuantity=1;
		
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
	
	
}
