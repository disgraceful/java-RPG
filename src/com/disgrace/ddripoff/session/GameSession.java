package com.disgrace.ddripoff.session;

import com.disgrace.ddripoff.characters.heroes.HeroRoster;
import com.disgrace.ddripoff.hub.Town;

public class GameSession {
	private static HeroRoster heroRoster = new HeroRoster();;
	private static Town town = new Town();
	private static int gold = 0;
	
	private final GameSession SESSION= new GameSession();
	
	public GameSession getInstance(){
		return SESSION;
	}
	
	private GameSession(){
		
	}
}
