package ddripoffmodel;

import java.util.ArrayList;

public abstract class Character{
	private String name;
	
	public String getName(){
		return name;
	}
	public Character(String name,ArrayList<Stat> stat) {
		this.name = name;
		this.stats = new StatWrapper(stat);
	}
	protected StatWrapper stats;
	

}
