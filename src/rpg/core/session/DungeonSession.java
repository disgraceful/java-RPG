package rpg.core.session;

import java.util.List;

import rpg.core.characters.shared.Character;
import rpg.core.characters.shared.Party;
import rpg.core.dungeon.Corridor;
import rpg.core.dungeon.CorridorSection;
import rpg.core.dungeon.Dungeon;
import rpg.core.dungeon.Room;
import rpg.core.dungeon.events.SpawnEvent;
import rpg.core.game.GameTurn;
import rpg.core.items.Loot;
import rpg.core.utils.CalcHelper;

public class DungeonSession {
	private boolean active;
	private Dungeon dungeon;
	private Party chosenParty;
	private Room currentRoom;
	private SpawnEvent currentSpawnEvent;
	private boolean userChoice;
	private DungeonSessionInventory inventory = new DungeonSessionInventory();
	private static int chanceToFlee = 50;
	
	private static DungeonSession session = new DungeonSession();

	private DungeonSession() {
	}

	public static DungeonSession getSession() {
		if (session == null) {
			session = new DungeonSession();
		}
		return session;
	}

	public void initiateSession(Dungeon dungeon, Party party) {
		this.dungeon = dungeon;
		chosenParty = party;
		active = true;
	}

	public void startDungeon() {
		dungeon.getStartRoom().enter();
		currentRoom = dungeon.getStartRoom();
		currentRoom.getNeighbours().forEach(e -> e.display());
	}

	public void travelToRoom(Room current, Room destination) {
		current.leave();
		Corridor travelingCorridor = current.getCorridor(destination);
		for (CorridorSection section : travelingCorridor.getSections()) {
			section.enter();
			section.displayUntriggeredEvents();
			if (userChoice && section.hasUntriggeredEvents()) {
				section.getUntriggeredEvents().forEach(e -> interactWith(e));
			}
			section.leave();
		}
		currentRoom = destination;
		if(dungeon.getEnterableRooms().stream().allMatch(e->e.isVisited())) {
			finishDungeon();
		}
	}

	public void interactWith(SpawnEvent event) {
		event.trigger();
	}

	public void engageInFight(Party bad) {
		List<Character> queue = bad.getMembers();
		queue.addAll(chosenParty.getMembers());
		while (!bad.isPartyDead() && !chosenParty.isPartyDead()) {
			GameTurn.turn(queue);
		}
	}

	public void collectLoot(Loot loot) {
		inventory.addLoot(loot);
	}

	public void finishDungeon() {
		System.out.println("Finished dungeon, going to town, getting loot, getting exp, getting reward");
		active = false;
	}
	
	public static void fleeDungeon() {
		System.out.println("Dungeon not finished, going to town, getting loot, no exp, no reward");
		if(CalcHelper.randInt(100)<chanceToFlee) {
			System.out.println("fleeing successful");
		}
		else {
			System.out.println("fleeing not succesful");
		}
	}

}
