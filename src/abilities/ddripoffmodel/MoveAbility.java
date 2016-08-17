package abilities.ddripoffmodel;

import java.util.ArrayList;
import java.util.Random;

import ddripoffmodel.Stat;
import ddripoffmodel.StatEnumeration;
import ddripoffmodel.StatWrapper;

public class MoveAbility extends Ability {

	public MoveAbility(String name, ArrayList<Stat> stat) {
		super(name, stat);
		newPos = affectedStats.getStatbyName(StatEnumeration.Position).getCurValue(); 
	}
	
	private final int newPos;

	@Override
	public void useAbility(StatWrapper[] targets, StatWrapper user) {
		for(StatWrapper t :targets){
			if(ifMoveSuccesful(t,user)){
				int currentPos = t.getOwner().getPosition();
				t.getOwner().getParty().reposition(t.getOwner(), currentPos+newPos);
			}
		}
	}
	
	private boolean ifMoveSuccesful(StatWrapper target, StatWrapper user){
		//int targetDef = target.getStatbyName(StatEnumeration.MoveResist).getCurValue();
		Random rand = new Random();
		int chance = rand.nextInt(100);
		return true;
				//chance>targetDef;
	}
}
