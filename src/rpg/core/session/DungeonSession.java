package rpg.core.session;

import java.util.ArrayList;
import java.util.List;

import rpg.core.characters.shared.Party;
import rpg.core.dungeon.Corridor;
import rpg.core.dungeon.CorridorSection;
import rpg.core.dungeon.Dungeon;
import rpg.core.dungeon.Room;
import rpg.core.dungeon.events.SpawnEvent;
import rpg.core.items.Item;
import rpg.core.items.Loot;

public class DungeonSession {
	private boolean active;
	private Dungeon dungeon;
	private Party chosenParty;
	private Room currentRoom;
	private SpawnEvent currentSpawnEvent;
	private boolean userChoice;
	private List<Item> inventory = new ArrayList<>();
	private static final int INVENTORY_CAP = 20;

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
	}

	public void interactWith(SpawnEvent event) {
		event.trigger();
	}

	public void engageInFight(Party bad) {

	}
	
	public void collectLoot(Loot loot) {
		
	}
	
	private void orderInventory() {
		
	}
}
