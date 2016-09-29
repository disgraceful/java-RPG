package com.disgrace.ddripoff.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import com.disgrace.ddripoff.locations.Dungeon;
import com.disgrace.ddripoff.locations.Room;

public class DungeonGenerator {

	static Dungeon dungeon;
	public static void generateDungeon(int size) {
		ArrayList<Room> dungeon1 = new ArrayList<Room>() {
			{
				add(new Room(0, 0));
				add(new Room(1, 0));
				add(new Room(2, 0));

				add(new Room(0, 1));
				add(new Room(1, 1));
				add(new Room(2, 1));

				add(new Room(0, 2));
				add(new Room(1, 2));
				add(new Room(2, 2));
			}
		};
		dungeon = new Dungeon(dungeon1);

		for (Room r : dungeon.rooms) {
			r.neighbours.add(dungeon.getBy(r.x - 1, r.y));
			r.neighbours.add(dungeon.getBy(r.x + 1, r.y));
			r.neighbours.add(dungeon.getBy(r.x, r.y - 1));
			r.neighbours.add(dungeon.getBy(r.x, r.y + 1));

			Iterator<Room> roomIter = r.neighbours.iterator();
			while (roomIter.hasNext()) {
				Room room = roomIter.next();
				if (room == null) {
					roomIter.remove();
				}
			}
		}

		print();
	}

	private static void generateLvl(){
		int maxSkips = (int)dungeon.rooms.size()/3; 
		Collections.shuffle(dungeon.rooms);
		Iterator<Room> iter = dungeon.rooms.iterator();
//		while(iter.hasNext ()){
//		
//			Room r = iter.next();
//			
//		}
		
		
		while(maxSkips!=0){
			int randIndex = (int) (Math.random()*dungeon.rooms.size());
			Room r =dungeon.rooms.get(randIndex);
			if(!r.ifNeighboursAlone()){
				r.value=1;
				maxSkips--;
			}
		}
		print();
	}
	
	public static void main(String[] args) {
		generateDungeon(3);
		generateLvl();
	}
	
	private static void print(){
		System.out.println("");
		 for (int i = 0; i < dungeon.rooms.size(); i++) {
			if(i==2|i==5|i==8){
				System.out.println(dungeon.rooms.get(i).value );
			}
			else{
				System.out.print(dungeon.rooms.get(i).value+" " );
			}
			
		}
	}
}