package rpg.core.dungeon;

public class DungeonSize {
	DungeonSizeEnum size; 
	int xbound;
	int ybound;
	int minRooms;
	int maxFightAmount;
	int minFightAmount;
	
	public DungeonSize(DungeonSizeEnum size, int height, int width,int rooms,int fightAmount){
		this.size = size;
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
	
}
