package rpg.core.dungeon;

import javax.xml.bind.annotation.XmlRootElement;


public class Desert extends Dungeon {
	
	public Desert(DungeonSize size){
		super(size);
		dungType = DungeonType.DESERT;
	}
}