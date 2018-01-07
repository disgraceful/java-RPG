package rpg.core.game;

import rpg.core.characters.shared.Character;

public class MoveCharacter implements PlayerDecision{

	private Character caller;
	private int posToMove;
	
	public MoveCharacter(Character caller, int posToMove) {
		this.caller = caller;
		this.posToMove = posToMove;
	}



	@Override
	public void performDecision() {
		caller.move(posToMove);
	}
}
