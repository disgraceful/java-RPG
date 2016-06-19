package ddripoffmodel;

import java.util.ArrayList;

public class StatWrapper {
	private Character owner;
	private ArrayList<Stat> stats = new ArrayList<Stat>();	
	
	public StatWrapper(ArrayList<Stat>stats){
		this.stats = stats;
	}
		
	private boolean checkIfStatExist(String name){
		for(Stat s :stats){
			if(s.getName() == name){
				return true;
			}	
		}
		return false;
	}
	
	public Stat getStatbyName(String name){
		for(Stat s : stats){
			if(s.getName()==name){
				return s;
			}
		}
		return null;
	}
	
	public ArrayList<Stat> getStatsasArrayList(){
		return stats;
	}
	public Character getOwner(){
		return owner;
	}
	public void setOwner(Character owner){
		this.owner = owner;
	}
	
	public void updateStats(StatWrapper affectedstats){
		for(Stat c :affectedstats.getStatsasArrayList()){
			
			if(this.checkIfStatExist(c.getName())){
				Stat curStat  = this.getStatbyName((c.getName()));
				int i= curStat.getCurValue();
				if(c.getIsAffectingMaxValue()){
					curStat.setMaxValue(curStat.getMaxValue()+c.getCurValue());
				}
				this.getStatbyName(c.getName()).setValue(i+c.getCurValue());
			}
		}
	}
	
	public static void reverseStatsValue(StatWrapper stat){
		for(Stat c:stat.getStatsasArrayList()){
			c.setValue(-c.getCurValue());
		}
	}
}
