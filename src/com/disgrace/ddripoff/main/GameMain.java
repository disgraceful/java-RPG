package com.disgrace.ddripoff.main;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FilenameUtils;

import com.disgrace.ddripoff.session.GameSession;
import com.disgrace.ddripoff.utils.GameTextDisplayer;
import com.disgrace.ddripoff.utils.SaveHelper;

public class GameMain {

	private static GameSession session;
	private static GameTextDisplayer displayer;
	private static Scanner sc;
	private static final Logger LOG = Logger.getLogger(GameMain.class.getSimpleName());

//	public static void main(String[] args) {
//		initGame();
//		welcome();
//		mainMenu();
//		handleMainMenu(readIntInput());
//	}

	private static void initGame() {
		session = GameSession.getSessionInstance();
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
			handleMainMenu(readIntInput());
			break;
		}
	}

	private static int readIntInput() {
		try {
			return sc.nextInt();
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Wrong input", e);
		}
		return -1;
	}

	private static String readStringInput() {
		sc.nextLine();
		return sc.nextLine();
	}

	private static void inputError() {
		displayer.displayInputError();
	}

	private static void exit() {
		System.exit(0); // indeed required
	}

	private static void startNewGame() {
		displayer.displayNewGameStart();
		System.out.print("My name is: ");
		String userName = readStringInput();
		session = GameSession.getSessionInstance();
		SaveHelper.saveUserToXml(session, userName);
		System.out.println("Game starting now!");
	}

	private static void continueNewGame() {
		System.out.println("you continued");
		displayer.displayActiveUsers(SaveHelper.getActiveUsersAsString());
		int select = readIntInput();
		String s = SaveHelper.getActiveUsersAsString().get(select - 1);
		session = (GameSession)SaveHelper.loadUserFromXml(FilenameUtils.removeExtension(s), GameSession.class);
	}

}
