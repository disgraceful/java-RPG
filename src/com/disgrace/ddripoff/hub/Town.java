package com.disgrace.ddripoff.hub;

public class Town {
	//private static Blacksmith BLACKSMITH;
	//private static SaviorsChurch CHURCH;
	private static final MercenaryCoach COACH;
	private static final TrinketShop SHOP;

	static{
		COACH = new MercenaryCoach();
		SHOP = new TrinketShop();
	}
	
	public void visitShop(){
		//TODO display Shop
	}
	
	public void visitCoach(){
		//TODO display Coach
	}
	
	public void visitDungeon(){
		//TODO select level;
	}
	
}
