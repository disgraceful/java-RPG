package ddripoffmodel;

import java.util.ArrayList;

public class StatWrapper {
	private ArrayList<Stat> stats = new ArrayList<Stat>();
	
	public StatWrapper(ArrayList<Stat>stats){
		this.stats = stats;
	}

	
	public boolean checkIfStatExist(String name){
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
	
	public ArrayList<Stat> getStats(){
		return stats;
	}
}
