package rpg.core.spawn.events;

import rpg.core.characters.shared.Party;
import rpg.core.session.DungeonSession;
import rpg.core.spawn.CharacterFactory;


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
