package rpg.core.dungeon;

public enum DungeonSize {
	TUTORIAL("Tutorial",1,2,2,2),SMALL("Small",2,3,4,9),MEDIUM("Medium",3,4,9,8),LARGE("Large",3,6,13,12);
	
	private String name; 
	int xbound;
	int ybound;
	int minRooms;
	int maxFightAmount;
	int minFightAmount;
	
	private DungeonSize(String name, int height, int width,int rooms,int fightAmount){
		this.name = name;
		ybound = height;
		xbound = width;
		minRooms = rooms;
		maxFightAmount = fightAmount;
		minFightAmount = minRooms+height;
	}
	
	public int getXbound(){
		return xbound;
	}
	
	public int getYBound(){
		return ybound;
	}
	
	public int getMinRooms(){
		return minRooms;
	}
	
	public int getMaxFightRooms(){
		return maxFightAmount;
	}
	
	public int getMaxFightAmount() {
		return maxFightAmount;
	}
	
	public int getMinFightAmount() {
		return minFightAmount;
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	
	
	
}
