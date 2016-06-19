package ddripoffmodel;

import java.util.ArrayList;

public class BuffAbility extends Ability {
	public BuffAbility(String name,ArrayList<Stat>stat){
		super(name,stat);
	}

	public void useAbility(StatWrapper[] targets,StatWrapper user){
		for(StatWrapper t :targets){
			t.updateStats(affectedstats);
			System.out.println(t.getOwner().getName() + " has been buffed");
		}
	}

	
}
