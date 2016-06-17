package ddripoffmodel;

import java.util.ArrayList;

public class Ability {

	private String name;
	private StatWrapper affectedstats;
	public String getName(){
		return name;
	}
	
	public StatWrapper getStats(){
		return affectedstats;
	} 
	
	public Ability(String name, ArrayList<Stat>stat){
		this.name = name;
		this.affectedstats = new StatWrapper(stat);
		
	}
	
}
