package rpg.core.spawn.events;

import rpg.core.characters.shared.Party;
import rpg.core.session.DungeonSession;
import rpg.core.spawn.CharacterFactory;

public class Fight extends SpawnEvent {

	private Party enemyParty;

	public Fight() {
		spawnType = SpawnableEventType.FIGHT;
		enemyParty = CharacterFactory.spawnRandomParty();
	}

	public void setEnemyParty(Party party) {
		enemyParty = party;
	}

	public Party getEnemyParty() {
		return enemyParty;
	}

	@Override
	public void trigger() {
		if (!triggered) {

		}
		DungeonSession.getSession().engageInFight(enemyParty);
	}
}
