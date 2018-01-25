package rpg.core.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import rpg.core.characters.heroes.HeroClass;
import rpg.core.characters.heroes.classes.Centurion;
import rpg.core.characters.heroes.classes.Priest;
import rpg.core.characters.shared.Party;
import rpg.core.dungeon.DungeonBuilder;
import rpg.core.dungeon.TutorialDungeon;
import rpg.core.factories.CharacterFactory;
import rpg.core.game.states.GameMenu;
import rpg.core.session.DungeonSession;
import rpg.core.session.GameSession;

public class GameMain extends StateBasedGame {

	public GameMain(String name) {
		super(name);
		this.addState(new GameMenu(MENU));
	}

	private static GameSession gameSession;
	private static DungeonSession currentDungeonSession;
	private static final String GAME_NAME = "Cool game";
	private static final int MENU = 0;
	private static final int DUNGEON = 1;
	private static final int TOWN = 2;

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(MENU).init(gc, this);
		this.enterState(MENU);

	}

	public static void main(String[] args) {
		startGame();
	}

	public static void startGame() {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new GameMain(GAME_NAME));
			appgc.setDisplayMode(1920, 1080, false);
			appgc.setFullscreen(true);
			appgc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}

	public static void preload() {
		gameSession = GameSession.getSessionInstance();
		Centurion centurion = (Centurion) CharacterFactory.spawnCharByType(HeroClass.CENTURION);
		Priest priest = (Priest) CharacterFactory.spawnCharByType(HeroClass.PRIEST);
		gameSession.hireHero(centurion);
		gameSession.hireHero(priest);
		Party party = new Party();
		party.addMember(centurion);
		party.addMember(priest);

		TutorialDungeon tutorial = new TutorialDungeon();
		DungeonBuilder.build(tutorial);
		currentDungeonSession = DungeonSession.getSession();
		currentDungeonSession.initiateSession(tutorial, party);
		currentDungeonSession.startDungeon();

	}

}
