package rpg.core.session;

import java.util.HashSet;
import java.util.Set;

import rpg.core.characters.shared.Party;
import rpg.core.dungeon.Dungeon;
import rpg.core.dungeon.Enterable;
import rpg.core.dungeon.Room;
import rpg.core.items.Item;
import rpg.core.spawn.events.SpawnEvent;

public class DungeonSession {
	private boolean active;
	private Dungeon dungeon;
	private Party chosenParty;
	private Room startRoom;
	private Enterable currentRoom;
	private Set<Item> inventory = new HashSet<>();

	private static final DungeonSession DUNGEON_SESSION_INSTANCE = new DungeonSession();

	private DungeonSession() {
	}

	public static DungeonSession getSession() {
		return DUNGEON_SESSION_INSTANCE;
	}

	public void initiateSession(Dungeon dungeon, Party party) {
		this.dungeon = dungeon;
		chosenParty = party;
		startRoom = dungeon.getStartRoom();
	}

	public void startDungeon() {
		startRoom.enter();
		currentRoom = startRoom;
	}

	public void goToEnterable(Enterable destination, Enterable current) {
		current.leave();
		destination.enter();
		currentRoom = destination;
	}

	public void interactWith(SpawnEvent event) {
		event.trigger();
	}

	public void engageInFight(Party bad) {

	}
}
