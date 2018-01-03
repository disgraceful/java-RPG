package rpg.core.session;

import java.util.HashSet;
import java.util.Set;

import rpg.core.characters.heroes.Hero;
import rpg.core.characters.heroes.HeroClass;
import rpg.core.dungeon.DungeonBuilder;
import rpg.core.dungeon.DungeonSize;
import rpg.core.dungeon.Ruins;
import rpg.core.factories.CharacterFactory;
import rpg.core.hub.HeroRoster;
import rpg.core.hub.Town;
import rpg.core.items.Item;

public class GameSession {

	private HeroRoster heroRoster = new HeroRoster();
	private Town town = new Town();
	private long gold = 0;
	private Set<Item> playerInventory = new HashSet<>();
	private ProgressionHolder progress = new ProgressionHolder();
	
	private static GameSession session;

	private GameSession() {
	}

	public static GameSession getSessionInstance() {
		if (session == null) {
			session = new GameSession();
		}
		return session;
	}

	public long getGold() {
		return gold;
	}

	public HeroRoster getHeroRoster() {
		return heroRoster;
	}

	public void setHeroRoster(HeroRoster heroRoster) {
		this.heroRoster = heroRoster;
	}

	public Town getTown() {
		return town;
	}

	public void setTown(Town town) {
		this.town = town;
	}

	public Set<Item> getPlayerInventory() {
		return playerInventory;
	}

	public void setPlayerInventory(Set<Item> playerInventory) {
		this.playerInventory = playerInventory;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public static void setSessionInstance(GameSession sessionInstance) {
		GameSession.session = sessionInstance;
	}

	public void addGold(int gold) {
		this.gold = -gold;
	}

	public void dismissHero(Hero hero) {
		heroRoster.dismissHero(hero);
	}

	public void hireHero(Hero hero) {
		heroRoster.hireHero(hero);
	}

	public void addItem(Item item) {
		playerInventory.add(item);
	}

	public void removeItem(Item item) {
		playerInventory.remove(item);
	}

	
	public void restoreSession() {
		// TODO load game
	}

	public void saveSession() {
		// TODO save game;
	}

	
	
}
