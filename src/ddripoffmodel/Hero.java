package ddripoffmodel;

import java.util.ArrayList;

public class Hero extends Character {
	
	public Hero(String name){
		super(name);
		 stats = new StatWrapper(new ArrayList<Stat>(){{
				add(new Stat("Health",10));
				add(new Stat("Armor",2));
				add(new Stat("Damage",5));
			}});
	}
	
	
	private ArrayList<Trinket> inventory = new ArrayList<Trinket>();
	
	public void equip(Trinket trinket){
		if(trinket.tryEquip(this)){
			inventory.add(trinket);
		}
	}
	
	public ArrayList<Trinket> getItems(){
		return inventory;
	}		
	
	public StatWrapper getStatWrapper(){
		return stats;
		
	}
}
