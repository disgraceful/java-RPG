package rpg.core.spawn.events;

import java.util.List;

import rpg.core.characters.shared.Party;
import rpg.core.session.DungeonSession;
import rpg.core.spawn.CharacterFactory;
import rpg.core.spawn.PartySpawnPattern;
import rpg.core.spawn.PartySpawnPatternEnumeration;
import rpg.core.utils.CalcHelper;

public abstract class Fight extends SpawnEvent {

	protected Party enemyParty;
	List<PartySpawnPatternEnumeration> avaliableEnumerations;

	public Fight() {
		spawnType = SpawnableEventType.FIGHT;
		enemyParty = CharacterFactory.spawnPartyByPattern(getRandomPattern());
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

	public PartySpawnPattern getRandomPattern() {
		return avaliableEnumerations.get(CalcHelper.getRandomInt(avaliableEnumerations.size())).getPattern();
	}
}
