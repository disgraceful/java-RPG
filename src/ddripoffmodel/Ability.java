package ddripoffmodel;

import java.util.ArrayList;

public abstract class Ability {

	private String name;
	protected StatWrapper affectedstats;
	protected String description;
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
	
	public void useAbility(StatWrapper[] targets,StatWrapper user){}

	public String getDescription() {
		return description;
	}
	
	public void setDecsription(String description){
		this.description = description;
	}
}
