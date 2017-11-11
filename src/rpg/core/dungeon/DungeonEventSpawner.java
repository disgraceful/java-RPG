package rpg.core.dungeon;

import java.util.ArrayList;
import java.util.List;

import rpg.core.spawn.events.Fight;
import rpg.core.spawn.events.FightType;
import rpg.core.spawn.events.SpawnEvent;
import rpg.core.spawn.events.SpawnableEventType;
import rpg.core.utils.CalcHelper;

public class DungeonEventSpawner {
	private static List<Enterable> alldungEnterables = new ArrayList<>();
	private static int maxFightAmount;
	private static int minFightAmount;
	private static Room startRoom;
	private static int fightsInDung;
	private static List<Corridor> corridors = new ArrayList<>();

	private DungeonEventSpawner() {
	}

	private static void init(Dungeon dungeon) {
		maxFightAmount = dungeon.size.maxFightAmount;
		minFightAmount = dungeon.size.minFightAmount;
		alldungEnterables = dungeon.getAllEnterables();
		startRoom = dungeon.getStartRoom();
		corridors = dungeon.getAllCorridors();
	}

	public static void generate(Dungeon dungeon) {
		init(dungeon);
		generateFights();
		// generateEvents(SpawnableEventType.TREASURE);
		// generateEvents(SpawnableEventType.CURIO);
	}

	private static void generateFights() {
		int noFightsCounter = 0;
		int fightChance = SpawnableEventType.FIGHT.getChance();
		int curFightChance = fightChance;
		int fightsInHallway = 0;
			for (Enterable enterable : alldungEnterables) {
			if(enterable instanceof Room){
				
			}
			SpawnEvent fight = spawnEventByChance(SpawnableEventType.FIGHT, curFightChance);
			if (canAddEvent(enterable, fight)) {
				enterable.addEvent(fight);
				fightsInDung++;

				noFightsCounter = 0;
				curFightChance = fightChance;
			} else {
				noFightsCounter++;
				if (noFightsCounter >= 3) {
					curFightChance += 50;
				}
			}
			enterable.display();
			if (!enterable.getEvents().isEmpty() && fight != null) {
				System.out.println(enterable.getEvents().get(0).getClass());
			}
			if (fightsInDung >= maxFightAmount) {
				break;
			}
		}
		if (fightsInDung < minFightAmount) {
			generateFights();
		}
	}

	private static void generateEvents(SpawnableEventType eventType) {
		for (Enterable enterable : alldungEnterables) {
			SpawnEvent event = spawnEventByChance(eventType, eventType.getChance());
			if (enterable instanceof Room) {
				event = spawnEventByChance(eventType, eventType.getChance() + 25);
			}
			if (canAddEvent(enterable, event)) {
				enterable.addEvent(event);
			}
		}
	}

	private static boolean canAddEvent(Enterable enterable, SpawnEvent event) {
		return !(enterable.equals(startRoom) || checkFirstSection(startRoom, enterable)) && event != null
				&& enterable.canAddSpawnEvent(event.getSpawnType());
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
