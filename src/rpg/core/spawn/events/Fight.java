package rpg.core.spawn.events;

import java.util.List;

import rpg.core.characters.shared.Party;
import rpg.core.items.Item;
import rpg.core.session.DungeonSession;
import rpg.core.spawn.CharacterFactory;
import rpg.core.spawn.PartySpawnPattern;
import rpg.core.spawn.PartySpawnPatternEnumeration;
import rpg.core.utils.CalcHelper;

public abstract class Fight extends SpawnEvent {

	protected Party enemyParty;
	protected List<PartySpawnPatternEnumeration> avaliableEnumerations;
	protected List<Item>loot;
	
	public Fight() {
		spawnType = SpawnableEventType.FIGHT;
	}

	public void spawn() {
		enemyParty = CharacterFactory.spawnPartyByPattern(getRandomPattern());
		//loot = ItemFactory.
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
		return avaliableEnumerations.get(CalcHelper.randInt(avaliableEnumerations.size())).getPattern();
	}
}
