package com.disgrace.ddripoff.locations.hub;

public enum ChurchRelieves {
	MEDITATION(1000,45),
	PRAY(1250,55),
	FLAGELLATION(1500,65);
	
	private int level;
	private int cost;
	private int stress;
	 
	public int getLevel(){
		return level;
	}
	
	public void setLevel(int lvl){
		if(lvl>1){
			level =lvl;
		}
	}
	
	public int getCost(){
		return cost;
	}
	
	public void setCost(int cost){
		if(cost>0){
			this.cost = cost;
		}
	}
	
	public int getStress(){
		return stress;
	}
	
	public void setStress(int stress){
		if(stress>0){
			this.stress = stress;
		}
	}
	
	ChurchRelieves(int cost,int stress){
		level =1;
	}
	
}
