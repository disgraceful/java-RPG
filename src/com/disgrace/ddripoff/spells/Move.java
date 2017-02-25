package com.disgrace.ddripoff.spells;

import java.util.Random;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.StatEnumeration;

public abstract class Move extends Effect {

	@Override
	public void applyEffect(Character caller, Character target) {
		if (isApplyingOnSelf(caller, target)) {
			performMove(caller, target);
		} else {
			if (isMoveSuccesful(caller, target)) {
				performMove(caller, target);
			} else {
				System.out.println("Resisted!");
			}
		}
	}

	private boolean isMoveSuccesful(Character caller, Character target) {
		int targetDef = target.getStatbyName(StatEnumeration.MOVE_RES).getCurValue();
		int callerChanceMultiplier = caller.getStatbyName(StatEnumeration.MOVE_CHANCE).getCurValue();
		int oddsToMove = effectStats.getStatbyName(StatEnumeration.MOVE_CHANCE).getCurValue();
		int sum = oddsToMove - targetDef + callerChanceMultiplier;
		int randChance = new Random().nextInt(101);
		System.out.println("targetDef " + targetDef + " callerMod " + callerChanceMultiplier + " Odds: " + oddsToMove
				+ " randChance " + randChance);
		return randChance < sum ? true : false;
	}

	private void performMove(Character caller, Character target) {
		int currentPos = target.getPosition();
		int newPos = currentPos + effectStats.getStatbyName(StatEnumeration.MOVE_SPELL_POSITION).getCurValue();
		target.move(newPos);
		System.out.println(target.toString() + " moves from " + currentPos + " to " + newPos + " Current pos: "
				+ (target.getPosition() + 1));
		return;
	}

}
