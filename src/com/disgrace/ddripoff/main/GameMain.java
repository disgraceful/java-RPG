package com.disgrace.ddripoff.main;

import java.util.Scanner;

import com.disgrace.ddripoff.session.GameSession;
import com.disgrace.ddripoff.utils.GameTextDisplayer;

public class GameMain {

	private static GameSession session;
	private static GameTextDisplayer displayer;
	private static Scanner sc;

	public static void main(String[] args) {
		initGame();
		welcome();
		mainMenu();
		handleMainMenu(readInput());
	}

	private static void initGame() {
		session = GameSession.getSession();
		displayer = GameTextDisplayer.getInstance();
		sc = new Scanner(System.in);
	}

	private static void welcome() {
		displayer.displayWelcomeMessage();
	}

	private static void mainMenu() {
		displayer.displayMainMenu();
	}

	private static void handleMainMenu(int input) {
		switch (input) {
		case 1:
			startNewGame();
			break;
		case 2:
			continueNewGame();
			break;
		case 3:
			exit();
			break;
		default:
			inputError();
			mainMenu();
			handleMainMenu(input);
			break;
		}
	}

	private static int readInput() {
		return sc.nextInt();
	}

	private static void inputError() {
		displayer.displayInputError();
	}

	private static void exit() {
		System.exit(0); // indeed required
	}

	private static void startNewGame() {
		System.out.println("you started a new game");
	}

	private static void continueNewGame() {
		System.out.println("you continued");
	}
}
