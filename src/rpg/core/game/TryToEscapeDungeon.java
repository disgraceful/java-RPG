package rpg.core.game;

import rpg.core.session.DungeonSession;

public class TryToEscapeDungeon implements PlayerDecision{

	@Override
	public void performDecision() {
		DungeonSession.fleeDungeon();
	}

	
}
