package rpg.core.dungeon;

public class UniqueDungeonBuilder extends DungeonBuilder {

	private UniqueDungeonBuilder() {
	}

	public static void build(Dungeon buildingDungeon) {
		init(buildingDungeon);
		setRoomRelations();
		decideBuild(dungeon.size);
		setRoomCorridors();
		dungeon.setStartingRoom();
	}

	private static void decideBuild(DungeonSize size) {
		switch (size) {
		case TUTORIAL:
			buildTutorial();
			break;
		case VOID_LVL1:
			buildVodlvl1();
			break;
		case VOID_LVL2:
			buildVodlvl2();
			break;
		case VOID_LVL3:
			buildVodlvl3();
			break;
		default:
			return;
		}
	}
	
	private static void buildTutorial() {
		
	}
	
	private static void build 

}
