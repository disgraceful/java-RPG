package com.disgrace.ddripoff.utils;

public class GameTextDisplayer implements TextDisplayerConstants {

	private static GameTextDisplayer gtdInstance = null;

	private GameTextDisplayer() {
	}
	
	public static GameTextDisplayer getInstance(){
		if (gtdInstance == null) {
			gtdInstance = new GameTextDisplayer();
		}
		return gtdInstance;
	}
	
	public void displayWelcomeMessage(){
		System.out.println(TextDisplayerConstants.WELCOME_MESSAGE);
	}

	public void displayMainMenu() {
		System.out.println(TextDisplayerConstants.NEW_GAME);
		System.out.println(TextDisplayerConstants.CONTINUE);
		System.out.println(TextDisplayerConstants.EXIT);
	}
	
	public void displayInputError(){
		System.out.println(TextDisplayerConstants.INPUT_ERROR);
	}
}
