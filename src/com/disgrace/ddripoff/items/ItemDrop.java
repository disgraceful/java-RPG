package com.disgrace.ddripoff.items;

public enum ItemDrop {
	TRINKET_DROP(30),
	TREASURE_DROP(100),
	CONSUMABLE_DROP(60);
	
	private int drop;
	private ItemDrop(int drop){
		this.drop = drop;
	}
	public int getDrop(){
		return drop;
	}
}
