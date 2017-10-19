package rpg.core.loader;

import java.util.ArrayList;
import java.util.List;

import rpg.core.characters.enemies.OutcastCrossbowman;
import rpg.core.characters.enemies.OutcastKnight;
import rpg.core.characters.enemies.OutcastSwordsman;
import rpg.core.characters.enemies.TestingDummy;
import rpg.core.characters.heroes.classes.Centurion;
import rpg.core.characters.heroes.classes.Dishonored;
import rpg.core.characters.heroes.classes.Priest;
import rpg.core.characters.heroes.classes.Purifier;
import rpg.core.characters.heroes.classes.UberHeroTest;
import rpg.core.characters.shared.Character;

public class GameLoader {

	private static final GameLoader INSTANCE = new GameLoader();
	private static List<Character> gameData; 
	private GameLoader() {
		gameData = new ArrayList<Character>() {
			{
				add(new OutcastCrossbowman());
				add(new OutcastSwordsman());
				add(new OutcastKnight());
				add(new TestingDummy());
				add(new Centurion());
				add(new Dishonored());
				add(new Priest());
				add(new Purifier());
				add(new UberHeroTest());
			}
		};

	}

	public static GameLoader getInstance() {
		return INSTANCE;
	}

	public <T> Character getDataByClass(Class<T> clazz) {
		return gameData.stream().filter(e->e.getClass()==clazz).findAny().get();
	}

}
