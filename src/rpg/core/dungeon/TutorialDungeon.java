package rpg.core.dungeon;

import rpg.core.characters.enemies.EnemyClass;
import rpg.core.characters.shared.Party;
import rpg.core.dungeon.events.fight.ConcreteFight;
import rpg.core.dungeon.events.fight.Fight;
import rpg.core.factories.CharacterFactory;
import rpg.core.factories.LootFactory;
import rpg.core.items.Loot;
import rpg.core.items.treasure.TreasureType;

public class TutorialDungeon extends Ruins {

	public TutorialDungeon() {
		super(new DungeonSize(DungeonSizeEnum.SMALL, 1, 2, 2, 1));
		DungeonBuilder.build(this);
		this.setStartRoom(rooms[0][0]);
	}

	private void setUPEvents() {
		Party firstEncounter = new Party();
		firstEncounter.addMember(CharacterFactory.spawnCharByType(EnemyClass.OUTCAST_SWORDSMAN));
		Loot firstEncounterLoot = LootFactory.spawnSpecificLoot(100,TreasureType.GOLD);
		Fight firstFight = new ConcreteFight(firstEncounter, firstEncounterLoot);
		
		Party secondEncounter = new Party();
		secondEncounter.addMember(CharacterFactory.spawnCharByType(EnemyClass.OUTCAST_KNIGHT));
		secondEncounter.addMember(CharacterFactory.spawnCharByType(EnemyClass.OUTCAST_CROSSBOWMAN));
		Loot secondEncounterLoot = LootFactory.spawnSpecificLoot(new int[]{100,1},TreasureType.GOLD,TreasureType.BATTLE_TROPHIES);
		Fight secondFight = new ConcreteFight(secondEncounter,secondEncounterLoot);
		
	}

}
