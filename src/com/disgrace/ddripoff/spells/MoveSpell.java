package com.disgrace.ddripoff.spells;

import java.util.Random;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.StatEnumeration;

public abstract class MoveSpell extends Spell {
	
	@Override
	public void useSpell(Character[] targets, Character caller) {
		for(Character t :targets){
			if(ifMoveSuccesful(t,caller)){
				int currentPos = t.getPosition();
				int newPos = currentPos+abilityStats.getStatbyName(StatEnumeration.MOVE_SPELL_POSITION).getCurValue(); 
				t.move(newPos);
			}
		}
	}
	
	private boolean ifMoveSuccesful(Character target, Character caller){
		int targetDef = target.getStatWrapper().getStatbyName(StatEnumeration.MOVE_RES).getCurValue();
		int callerChanceMultiplier = caller.getStats().getStatbyName(StatEnumeration.MOVE_CHANCE).getCurValue();
		int oddsToMove = abilityStats.getStatbyName(StatEnumeration.MOVE_CHANCE).getCurValue();
		int sum = oddsToMove-targetDef+callerChanceMultiplier;
		return new Random().nextInt(101)<sum? true:false;
	}
}
