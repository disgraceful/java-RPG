package rpg.core.items;

public enum ItemDrop {
	TRINKET_DROP(20),
	TREASURE_DROP(100),
	CONSUMABLE_DROP(50);
	
	private int drop;
	private ItemDrop(int drop){
		this.drop = drop;
	}
	public int getDrop(){
		return drop;
	}
}
