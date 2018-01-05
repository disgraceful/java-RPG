package rpg.core.dungeon.events.fight;

import java.util.List;

import rpg.core.characters.shared.Party;
import rpg.core.dungeon.DungeonType;
import rpg.core.dungeon.events.SpawnEvent;
import rpg.core.dungeon.events.SpawnableEventType;
import rpg.core.factories.CharacterFactory;
import rpg.core.factories.LootFactory;
import rpg.core.session.DungeonSession;
import rpg.core.spawn.PartySpawnPattern;
import rpg.core.spawn.PartySpawnPatternEnumeration;
import rpg.core.utils.CalcHelper;

public abstract class Fight extends SpawnEvent {

	protected Party enemyParty;
	protected List<PartySpawnPatternEnumeration> avaliableEnumerations;

	public Fight() {
		spawnType = SpawnableEventType.FIGHT;
		initEvent();
		
	}

	public Fight(DungeonType restriction) {
		this();
		areaRestriction = restriction;
	}

	public Party getEnemyParty() {
		return enemyParty;
	}

	public PartySpawnPattern getRandomPattern() {
		return avaliableEnumerations.get(CalcHelper.randInt(avaliableEnumerations.size())).getPattern();
	}

	public abstract void initEvent();

	@Override
	public void trigger() {
		if (!triggered) {

		}
		DungeonSession.getSession().engageInFight(enemyParty);
	}

	@Override
	public void spawn() {
		enemyParty = CharacterFactory.spawnParty(getRandomPattern(), areaRestriction);
		loot = LootFactory.spawnLoot(lootType);
	}
}
