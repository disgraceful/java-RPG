package rpg.core.spells;

import java.util.Random;

import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;


public class Move extends Effect {

	public Move() {
	}

	public Move(StatWrapper stats) {
		this.effectStats = stats;
	}

	@Override
	public void applyEffect(Character caller, Character target) {
		if (isApplyingOnSelf(caller, target)) {
			performMove(caller, target);
		} else {
			if (isMoveSuccesful(caller, target)) {
				performMove(caller, target);
			} else {
				System.out.println(target.getName() + " resisted the move!");
			}
		}
	}

	private boolean isMoveSuccesful(Character caller, Character target) {
		int targetDef = target.getStatbyName(StatEnum.MOVE_RES).getCurValue();
		int callerChanceMultiplier = caller.getStatbyName(StatEnum.MOVE_CHANCE).getCurValue();
		int oddsToMove = effectStats.getStatbyName(StatEnum.MOVE_CHANCE).getCurValue();
		int sum = oddsToMove - targetDef + callerChanceMultiplier;
		int randChance = new Random().nextInt(101);
		System.out.println("targetDef " + targetDef + " callerMod " + callerChanceMultiplier + " Odds: " + oddsToMove
				+ " randChance " + randChance);
		return randChance < sum ? true : false;
	}

	private void performMove(Character caller, Character target) {
		int currentPos = target.getPosition();
		int newPos = currentPos + effectStats.getStatbyName(StatEnum.MOVE_SPELL_POSITION).getCurValue();
		target.move(newPos);
		System.out.println(target.toString() + " moves from " + currentPos + " to " + newPos + " Current pos: "
				+ (target.getPosition() + 1));
		return;
	}

}
