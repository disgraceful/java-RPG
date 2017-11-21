package rpg.core.spawn.events;

import java.util.List;

import rpg.core.characters.shared.Party;
import rpg.core.factories.CharacterFactory;
import rpg.core.factories.LootFactory;
import rpg.core.items.Loot;
import rpg.core.items.LootType;
import rpg.core.session.DungeonSession;
import rpg.core.spawn.PartySpawnPattern;
import rpg.core.spawn.PartySpawnPatternEnumeration;
import rpg.core.utils.CalcHelper;

public abstract class Fight extends SpawnEvent {

	protected Party enemyParty;
	protected List<PartySpawnPatternEnumeration> avaliableEnumerations;

	public Fight() {
		spawnType = SpawnableEventType.FIGHT;
	}

	public Party getEnemyParty() {
		return enemyParty;
	}

	public PartySpawnPattern getRandomPattern() {
		return avaliableEnumerations.get(CalcHelper.randInt(avaliableEnumerations.size())).getPattern();
	}

	@Override
	public void trigger() {
		if (!triggered) {

		}
		DungeonSession.getSession().engageInFight(enemyParty);
	}

	@Override
	public void spawn() {
		enemyParty = CharacterFactory.spawnPartyByPattern(getRandomPattern());
		loot = LootFactory.spawnLoot(lootType);
	}
}
