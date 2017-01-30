package com.disgrace.ddripoff.spawn;

import com.disgrace.ddripoff.characters.shared.Party;

public class Fight extends SpawnEvent {

	private final Party ENEMY_PARTY;
	
	public Fight() {
		ENEMY_PARTY = Party.spawnRandomParty();
		spawnType = SpawnableEventType.FIGHT;
		SPAWN_CHANCE = 25;
	}
	
	@Override
	public void trigger() {
		// TODO Auto-generated method stub	
	}
}
