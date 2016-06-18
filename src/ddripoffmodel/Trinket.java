package ddripoffmodel;

import java.util.ArrayList;

public class Trinket extends Item {
	private StatWrapper affectedstats;
	
	public Trinket(String name,ArrayList<Stat> affectedstats){
		setName(name);
		this.affectedstats =new StatWrapper(affectedstats);
	}
	
	public StatWrapper getStatWrapper(){
		return affectedstats;
	}
	 
	public boolean tryEquip(StatWrapper herostat){
		//if(hero.class!=restriction||restriction != all)
		//return false;
		affectedstats.updateStats(herostat);
		System.out.println(herostat.getOwner().getName()+" has equipped "+this.getName());
		return true; 
	}
	
	public boolean tryUnEquip(StatWrapper herostat){
		try{
			StatWrapper.reverseStatsValue(affectedstats);
			affectedstats.updateStats(herostat);
			System.out.println(herostat.getOwner().getName()+" has unequipped "+this.getName());
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
}
