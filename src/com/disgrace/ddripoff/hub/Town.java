package com.disgrace.ddripoff.hub;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.characters.shared.Party;
import com.disgrace.ddripoff.dungeon.Dungeon;
import com.disgrace.ddripoff.session.DungeonSession;

public class Town {
	private MercenaryCoach coach;
	private TrinketShop shop;

	public Town() {
		coach = new MercenaryCoach();
		shop = new TrinketShop();
	}

	public void setCoach(MercenaryCoach coach) {
		this.coach = coach;
	}

	public void setShop(TrinketShop shop) {
		this.shop = shop;
	}

	public TrinketShop getShop() {
		return shop;
	}

	public MercenaryCoach getCoach() {
		return coach;
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
