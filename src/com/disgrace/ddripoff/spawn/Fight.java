package com.disgrace.ddripoff.spawn;

import com.disgrace.ddripoff.characters.Party;

public class Fight extends SpawnEvent {

	protected final SpawnableEventType spawnType = SpawnableEventType.FIGHT;
	private final Party ENEMY_PARTY;
	
	public Fight() {
		ENEMY_PARTY = (Party) new Party().spawnParty(PartySpawnPatterns.getRandomPattern());
	}
	
	@Override
	public void trigger() {
		// TODO Auto-generated method stub	
	}
}
