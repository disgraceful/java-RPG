package ddripoffmodel;

import java.util.ArrayList;

public class Character implements Comparable<Character>{
	protected String name;
	protected StatWrapper stats;
	protected ArrayList<ITemporaryEffect> tempEffects = new ArrayList<ITemporaryEffect>();
	protected Party party;
	
	public String getName(){
		return name;
	}
	
	public Character(String name,ArrayList<Stat> stat) {
		this.name = name;
		this.stats = new StatWrapper(stat);
	}
		
	public StatWrapper getStatWrapper() {
		return stats;
	}
	
	public Party getParty(){
		return party;
	}
	
	public void setParty(Party party){
		this.party = party;
	}
	
	protected void Move(int newposition){
		party.reposition(this, newposition);
	}
	
	@Override
	public int compareTo(Character c1) {
		int comparespeed = ((Character)c1).getStatWrapper().getStatbyName("Speed").getCurValue();
		return comparespeed-this.stats.getStatbyName("Speed").getCurValue();
	}
}
