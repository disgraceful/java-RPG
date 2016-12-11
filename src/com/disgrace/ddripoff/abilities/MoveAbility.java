package com.disgrace.ddripoff.abilities;

import java.util.List;
import java.util.Random;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;

public abstract class MoveAbility extends Ability {

	public MoveAbility(String name, List<Stat> stat) {
		newPos = affectedStats.getStatbyName(StatEnumeration.POSITION).getCurValue(); 
	}
	
	private final int newPos;

	@Override
	public void useAbility(Character[] targets, Character caller) {
		for(Character t :targets){
			if(ifMoveSuccesful(t,caller)){
				int currentPos = t.getPosition();
				t.getParty().reposition(t, currentPos+newPos);
			}
		}
	}
	
	private boolean ifMoveSuccesful(Character target, Character caller){
		//int targetDef = target.getStatbyName(StatEnumeration.MoveResist).getCurValue();
		Random rand = new Random();
		int chance = rand.nextInt(100);
		return true;
				//chance>targetDef;
	}
}
