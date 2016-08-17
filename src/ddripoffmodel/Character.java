package ddripoffmodel;

import java.util.ArrayList;
import java.util.Collection;

import abilities.ddripoffmodel.ITemporaryEffect;

public class Character implements Comparable<Character>{
	private String name;
	private StatWrapper stats;
	private ArrayList<ITemporaryEffect>tempEffects= new ArrayList<ITemporaryEffect>(); 
	private Party party;
	
	
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
	
	public ArrayList<ITemporaryEffect> getEffectsList(){
		
		return tempEffects;
	}
	
	public int getPosition(){
		return party.getPosition(this);
	}
	
	protected void Move(int newposition){
		party.reposition(this, newposition);
	}
	
	@Override
	public int compareTo(Character c1) {
		int comparespeed = ((Character)c1).getStatWrapper().getStatbyName(StatEnumeration.Speed).getCurValue();
		return comparespeed-this.stats.getStatbyName(StatEnumeration.Speed).getCurValue();
	}
}
