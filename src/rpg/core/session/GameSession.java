package rpg.core.session;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlRootElement;

import rpg.core.characters.heroes.Hero;
import rpg.core.dungeon.Dungeon;
import rpg.core.hub.HeroRoster;
import rpg.core.hub.Town;
import rpg.core.items.Item;



public class GameSession implements Serializable {

	private static final long serialVersionUID = 1L;

	private HeroRoster heroRoster = new HeroRoster();
	private Town town = new Town();
	private int gold = 0;
	private Set<Item> playerInventory = new HashSet<>();
	private Set<Dungeon> allLevels = new HashSet<>();
	private Set<Dungeon> completedLevels = new HashSet<>();

	private static GameSession sessionInstance = null;

	private GameSession() {
	}

	public static GameSession getSessionInstance() {
		if (sessionInstance == null) {
			sessionInstance = new GameSession();
		}
		return sessionInstance;
	}

	public int getGold() {
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

	public Set<Dungeon> getAllLevels() {
		return allLevels;
	}

	public void setAllLevels(Set<Dungeon> allLevels) {
		this.allLevels = allLevels;
	}

	public Set<Dungeon> getCompletedLevels() {
		return completedLevels;
	}

	public void setCompletedLevels(Set<Dungeon> completedLevels) {
		this.completedLevels = completedLevels;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public static void setSessionInstance(GameSession sessionInstance) {
		GameSession.sessionInstance = sessionInstance;
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

	public void completeLevel(Dungeon dung) {
		completedLevels.add(dung);
	}

	public Set<Dungeon> displayUncompletedLevels() {
		return allLevels.stream().filter(e -> e.isCompleted()).collect(Collectors.toSet());
	}

	public void restoreSession() {
		// TODO load game
	}

	public void saveSession() {
		// TODO save game;
	}

}
