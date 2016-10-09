package com.disgrace.ddripoff.tests;

import java.util.Scanner;

import com.disgrace.ddripoff.characters.Party;
import com.disgrace.ddripoff.locations.dungeons.Desert;
import com.disgrace.ddripoff.locations.dungeons.Dungeon;
import com.disgrace.ddripoff.locations.dungeons.components.Room;
import com.disgrace.ddripoff.session.DungeonSession;

public class TestDungeon {
	static DungeonSession sess = new DungeonSession(new Desert(3));
	public static void testDung() {
		
		Dungeon exde = sess.dungeon;

		Party party = sess.chosenParty;
		Scanner scan = new Scanner(System.in);
		Room start = exde.startingRoom;
	
		while (!winCondition(exde)) {
			System.out.println("You are in " + start.toString());
			displayMoves(start);
			int userI = scan.nextInt();
			switch (userI) {
			case 1:
				startAdventure(start, start.getNorthNeig());
				start = start.getNorthNeig();
				break;
			case 2:
				startAdventure(start, start.getSouthNeig());
				start = start.getSouthNeig();
				break;
			case 3:
				startAdventure(start, start.getWestNeig());
				start = start.getWestNeig();
				break;
			case 4:
				startAdventure(start, start.getEastNeig());
				start = start.getEastNeig();
				break;
			}
			if (userI == 9) {
				System.out.println("fml");
				break;
			}
		}
	}

	private static void displayMoves(Room r){
		if(r.getNorthNeig()!=null){
			System.out.println("North room " + r.getNorthNeig().toString());
			System.out.println("1 to go to north");
		}
		if(r.getSouthNeig()!=null){
			System.out.println("South room " + r.getSouthNeig().toString());
			System.out.println("2 to go to south");
		}
		if(r.getWestNeig()!=null){
			System.out.println("West room " + r.getWestNeig().toString());
			System.out.println("3 to go to west");
		}
		if(r.getEastNeig()!=null){
			System.out.println("East  room " + r.getEastNeig().toString());
			System.out.println("4 to go to east");
		}
	}
	
	private static void startAdventure(Room begin, Room end){
		sess.startRoomAdventure(end, begin);
	}
	
	private static boolean winCondition(Dungeon d){
		for(Room r : d.rooms){
			if(r.visited==false){
			//System.err.println("exde");
				return false;
			}
		}
		return true;
	}

}
