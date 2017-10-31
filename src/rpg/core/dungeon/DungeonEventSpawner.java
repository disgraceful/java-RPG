package rpg.core.dungeon;

import java.util.ArrayList;
import java.util.List;

import rpg.core.spawn.events.SpawnEvent;
import rpg.core.spawn.events.SpawnableEventType;
import rpg.core.utils.CalcHelper;

public class DungeonEventSpawner {
	private static List<Enterable> alldungEnterables = new ArrayList<>();

	private static int maxFightAmount;
	private static int minFightAmount;
	private static Room startRoom;

	private DungeonEventSpawner() {
	}

	private static void init(Dungeon dungeon) {
		maxFightAmount = dungeon.size.maxFightAmount;
		minFightAmount = dungeon.size.minFightAmount;
		alldungEnterables = dungeon.getAllEnterables();
		startRoom = dungeon.getStartRoom();
	}

	public static void generate(Dungeon dungeon) {
		init(dungeon);
		generateFights();
		//generateEvents(SpawnableEventType.CURIO, SpawnableEventType.CURIO.getChance());
		//generateEvents(SpawnableEventType.TREASURE, SpawnableEventType.TREASURE.getChance());
	}

	private static void generateFights() {
		int fightsInDung = 0;
		int noFightsCounter = 0;
		int fightChance = SpawnableEventType.FIGHT.getChance();
		int curFightChance = fightChance;
		int fightsInHalway = 0;
		for (Enterable enterable : alldungEnterables) {
			//TODO not ROOOM neighbor but corridor first section.
			if (enterable.equals(startRoom) || startRoom.getNeighbours().contains(enterable)) {
				continue;
			}
			SpawnEvent fight = spawnEventByChance(SpawnableEventType.FIGHT, curFightChance);
			if (fight == null) {
				continue;
			}
			if (enterable.canAddSpawnEvent(fight.getSpawnType())) {
				if (fightsInHalway >= 4) {
					continue;
				}
				enterable.addEvent(fight);
				fightsInDung++;
				fightsInHalway++;
				noFightsCounter = 0;
				curFightChance = fightChance;
			} else {
				noFightsCounter++;
				if (noFightsCounter >= 3) {
					curFightChance += 50;
				}
			}
			if (enterable instanceof Room) {
				fightsInHalway = 0;
			}
			if (fightsInDung >= maxFightAmount) {
				break;
			}
		}
		if (fightsInDung < minFightAmount) {
			generateFights();
		}
	}

	private static void generateEvents(SpawnableEventType eventType, int spawnChance) {
		for (Enterable enterable : alldungEnterables) {
			if (enterable.equals(startRoom)) {
				continue;
			}
			SpawnEvent event = spawnEventByChance(eventType, eventType.getChance());
			if (event != null && enterable.canAddSpawnEvent(event.getSpawnType())) {
				enterable.addEvent(event);
			}
		}
	}

	private static SpawnEvent spawnEventByChance(SpawnableEventType eventType, int chance) {
		if (chance > 100) {
			chance = 100;
		}
		int threshold = CalcHelper.getRandomInt(101);
		if (threshold < chance) {
			return eventType.getEvent();
		} else {
			return null;
		}
	}
	
}
