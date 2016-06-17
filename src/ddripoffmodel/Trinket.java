package ddripoffmodel;

import java.util.ArrayList;

public class Trinket extends Item {
	private StatWrapper affectedstats;
	
	public Trinket(String name,ArrayList<Stat> affectedstats){
		setName(name);
		this.affectedstats =new StatWrapper(affectedstats);
	}
	 
	public boolean tryEquip(Hero hero){
		//if(hero.class!=restriction||restriction != all)
		//return false;
		for(Stat c :affectedstats.getStats()){
			if(hero.getStatWrapper().checkIfStatExist(c.getName())){
				int i=hero.getStatWrapper().getStatbyName(c.getName()).getValue();
				hero.getStatWrapper().getStatbyName(c.getName()).setValue(i+c.getValue());
			}
		}
		return true; 
	}
	
	public boolean tryUnEquip(Hero hero){
		try{
			
			for(Stat c :affectedstats.getStats()){
				if(hero.getStatWrapper().checkIfStatExist(c.getName())){
					int i=hero.getStatWrapper().getStatbyName(c.getName()).getValue();
					hero.getStatWrapper().getStatbyName(c.getName()).setValue(i-c.getValue());
				}
			}
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
}
