package com.disgrace.ddripoff.utils;

import java.util.List;

public class GameTextDisplayer implements TextDisplayerConstants {

	private static GameTextDisplayer gtdInstance = null;

	private GameTextDisplayer() {
	}

	public static GameTextDisplayer getInstance() {
		if (gtdInstance == null) {
			gtdInstance = new GameTextDisplayer();
		}
		return gtdInstance;
	}

	public void displayWelcomeMessage() {
		System.out.println(TextDisplayerConstants.WELCOME_MESSAGE);
	}

	public void displayMainMenu() {
		System.out.println(TextDisplayerConstants.NEW_GAME_MENU);
		System.out.println(TextDisplayerConstants.CONTINUE_MENU);
		System.out.println(TextDisplayerConstants.EXIT_MENU);
	}

	public void displayNewGameStart() {
		System.out.println(TextDisplayerConstants.ENTER_USERNAME);
	}

	public void displayInputError() {
		System.out.println(TextDisplayerConstants.INPUT_ERROR);
	}

	public void displayActiveUsers(List<String> users) {
		System.out.println("Select your save: ");
		users.stream().forEach(e -> System.out.println((users.indexOf(e)+1) + ". >" + e));
	}
}
