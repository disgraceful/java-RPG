package game;

import java.util.ArrayList;
import java.util.Collections;


public class Battle {
	ArrayList<Character> queue = new ArrayList<Character>();
	
	public void updateQueue() {
		for (Character c : queue) {
			// if(c.IsRIP())
			//queue.remove(c);
		}
	}

	public void formQueue(ArrayList<Character> characterlist) {
		Collections.sort(characterlist);
		queue = characterlist;
	}
}
	