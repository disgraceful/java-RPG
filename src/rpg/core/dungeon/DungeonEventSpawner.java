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
		// generateEvents(SpawnableEventType.CURIO,
		// SpawnableEventType.CURIO.getChance());
		// generateEvents(SpawnableEventType.TREASURE,
		// SpawnableEventType.TREASURE.getChance());
	}

	private static void generateFights() {
		int fightsInDung = 0;
		int noFightsCounter = 0;
		int fightChance = SpawnableEventType.FIGHT.getChance();
		int curFightChance = fightChance;
		int fightsInHallway = 0;
		for (Enterable enterable : alldungEnterables) {
			enterable.display();
			if (enterable instanceof Room) {
				fightsInHallway = 0;
				curFightChance+=25;
			}
			SpawnEvent fight = spawnEventByChance(SpawnableEventType.FIGHT, curFightChance);
			if (canAddEvent(enterable, fight) && fightsInHallway < 4) {
				enterable.addEvent(fight);
				fightsInDung++;
				fightsInHallway++;
				noFightsCounter = 0;
				curFightChance = fightChance;
			} else {
				noFightsCounter++;
				if (noFightsCounter >= 3) {
					curFightChance += 50;
				}
			}
			if (fightsInDung >= maxFightAmount) {
				break;
			}
			System.out.println(enterable.events);
		}
		if (fightsInDung < minFightAmount) {
			generateFights();
		}
	}

	private static boolean canAddEvent(Enterable enterable, SpawnEvent event) {
		return !(enterable.equals(startRoom) || checkFirstSection(startRoom, enterable)) && event != null
				&& enterable.canAddSpawnEvent(event.getSpawnType());
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

	private static boolean checkFirstSection(Room room, Enterable enterable) {
		return room.getCorridors().stream().anyMatch(e -> e.getSections().get(0).equals(enterable));
	}

}
