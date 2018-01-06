package rpg.core.dungeon;

import java.util.List;

import rpg.core.characters.enemies.EnemyClass;
import rpg.core.characters.shared.Party;
import rpg.core.dungeon.events.fight.ConcreteFight;
import rpg.core.dungeon.events.fight.Fight;
import rpg.core.dungeon.events.treasure.ConcreteTreasure;
import rpg.core.dungeon.events.treasure.Treasure;
import rpg.core.factories.CharacterFactory;
import rpg.core.factories.LootFactory;
import rpg.core.items.Loot;
import rpg.core.items.treasure.TreasureType;

public class TutorialDungeon extends Ruins {

	public TutorialDungeon() {
		super(new DungeonSize(DungeonSizeEnum.SMALL, 1, 2, 2, 1));
		DungeonBuilder.build(this);
		this.setStartRoom(rooms[0][0]);
		setUPEvents();
	}

	private void setUPEvents() {
		Party firstFightParty = new Party();
		firstFightParty.addMember(CharacterFactory.spawnCharByType(EnemyClass.OUTCAST_SWORDSMAN));
		Loot firstFightLoot = LootFactory.spawnSpecificLoot(100,TreasureType.GOLD);
		Fight firstFight = new ConcreteFight(firstFightParty, firstFightLoot);
		
		Party secondFightParty = new Party();
		secondFightParty.addMember(CharacterFactory.spawnCharByType(EnemyClass.OUTCAST_KNIGHT));
		secondFightParty.addMember(CharacterFactory.spawnCharByType(EnemyClass.OUTCAST_CROSSBOWMAN));
		Loot secondFightLoot = LootFactory.spawnSpecificLoot(new int[]{100,1},TreasureType.GOLD,TreasureType.BATTLE_TROPHIES);
		Fight secondFight = new ConcreteFight(secondFightParty,secondFightLoot);
		
		Treasure lastRoomTreasure = new ConcreteTreasure(Loot.EMPTY_LOOT);
		
		List<Enterable> enterables = getAllEnterables();
		enterables.get(2).addEvent(firstFight);
		enterables.get(6).addEvent(secondFight);
		enterables.get(6).addEvent(lastRoomTreasure);
	}

}
