package com.disgrace.ddripoff.session;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.characters.heroes.Hero;
import com.disgrace.ddripoff.characters.heroes.HeroRoster;
import com.disgrace.ddripoff.dungeon.Dungeon;
import com.disgrace.ddripoff.hub.Town;
import com.disgrace.ddripoff.items.Item;

@XmlRootElement
public class GameSession implements Serializable {

	private static final long serialVersionUID = 1L;

	private static HeroRoster heroRoster;
	private static Town town;
	private int gold;
	private static Set<Item> playerInventory;
	private static Set<Dungeon> allLevels;
	private static Set<Dungeon> completedLevels;

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

	public static HeroRoster getHeroRoster() {
		return heroRoster;
	}

	public static void setHeroRoster(HeroRoster heroRoster) {
		GameSession.heroRoster = heroRoster;
	}

	public static Town getTown() {
		return town;
	}

	public static void setTown(Town town) {
		GameSession.town = town;
	}

	public static Set<Item> getPlayerInventory() {
		return playerInventory;
	}

	public static void setPlayerInventory(Set<Item> playerInventory) {
		GameSession.playerInventory = playerInventory;
	}

	public static Set<Dungeon> getAllLevels() {
		return allLevels;
	}

	public static void setAllLevels(Set<Dungeon> allLevels) {
		GameSession.allLevels = allLevels;
	}

	public static Set<Dungeon> getCompletedLevels() {
		return completedLevels;
	}

	public static void setCompletedLevels(Set<Dungeon> completedLevels) {
		GameSession.completedLevels = completedLevels;
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
