package rpg.core.items;

public enum ItemType {
	TRINKET(15),
	TREASURE(100),
	CONSUMABLE(60);
	
	private int drop;
	
	private ItemType(int drop){
		this.drop = drop;
	}
	
	public int getDrop(){
		return drop;
	}
	


}
