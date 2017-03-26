package com.disgrace.ddripoff.session;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

import com.disgrace.ddripoff.characters.heroes.Hero;
import com.disgrace.ddripoff.characters.heroes.HeroRoster;
import com.disgrace.ddripoff.dungeon.Dungeon;
import com.disgrace.ddripoff.hub.Town;
import com.disgrace.ddripoff.items.Item;

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

	public static GameSession getSession() {
		if(sessionInstance==null){
			sessionInstance = new GameSession();
		}
		return sessionInstance;
	}

	public int getGold() {
		return gold;
	}

	public void addGold(int gold) {
		this.gold =- gold;
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
