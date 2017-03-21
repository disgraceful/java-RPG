package com.disgrace.ddripoff.hub;

import com.disgrace.ddripoff.characters.shared.Party;
import com.disgrace.ddripoff.dungeon.Dungeon;
import com.disgrace.ddripoff.session.DungeonSession;

public class Town {
	private static final MercenaryCoach COACH;
	private static final TrinketShop SHOP;

	static {
		COACH = new MercenaryCoach();
		SHOP = new TrinketShop();
	}

	public void visitShop() {
		// TODO display Shop
	}

	public void visitCoach() {
		// TODO display Coach
	}

	public void visitDungeon(Dungeon dungeon, Party party) {
		DungeonSession.getSession().initiateSession(dungeon, party);
		DungeonSession.getSession().startDungeon();
	}

}
