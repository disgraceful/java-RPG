package com.disgrace.ddripoff.spawn;

import com.disgrace.ddripoff.characters.shared.Party;

public class Fight extends SpawnEvent {

	private Party enemyParty;
	
	public Fight() {
		enemyParty = CharacterFactory.spawnRandomParty();
		spawnType = SpawnableEventType.FIGHT;
	}
	
	@Override
	public void trigger() {
		if(!triggered){
			
		}
		// TODO Engage in fight mode (Session)
	}
}
