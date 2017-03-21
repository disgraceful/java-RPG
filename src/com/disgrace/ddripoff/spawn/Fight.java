package com.disgrace.ddripoff.spawn;

import com.disgrace.ddripoff.characters.shared.Party;
import com.disgrace.ddripoff.session.DungeonSession;

public class Fight extends SpawnEvent {

	private Party enemyParty;

	public Fight() {
		enemyParty = CharacterFactory.spawnRandomParty();
		spawnType = SpawnableEventType.FIGHT;
	}

	@Override
	public void trigger() {
		if (!triggered) {

		}
		DungeonSession.getSession().engageInFight(enemyParty);
	}
}
