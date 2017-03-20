package com.disgrace.ddripoff.session;

import java.util.Set;
import java.util.stream.Collectors;

import com.disgrace.ddripoff.characters.heroes.Hero;
import com.disgrace.ddripoff.characters.heroes.HeroRoster;
import com.disgrace.ddripoff.dungeon.Dungeon;
import com.disgrace.ddripoff.hub.Town;
import com.disgrace.ddripoff.items.Item;

public class GameSession {
	private static HeroRoster heroRoster;
	private static Town town;
	private static int gold;
	private static Set<Item> playerInventory;
	private static Set<Dungeon> allLevels;
	private static Set<Dungeon> completedLevels;

	private static final GameSession SESSION_INSTANCE = new GameSession();

	private GameSession() {
	}

	public static GameSession getSession() {
		return SESSION_INSTANCE;
	}

	public int getGold() {
		return gold;
	}

	public void addGold(int gold) {
		GameSession.gold =- gold;
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
	
	public void restoreSession(){
		//TODO load game
	}
	
	public void saveSession(){
		//TODO save game;
	}

}
