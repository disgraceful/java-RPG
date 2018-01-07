package rpg.core.game;

import rpg.core.characters.heroes.Hero;
import rpg.core.characters.shared.Character;
public class Pass implements PlayerDecision{

	private  Character caller;
	public Pass(Character caller) {
		this.caller = caller;
	}
	
	@Override
	public void performDecision() {
		if(caller instanceof Hero) {
			System.out.println("stressed out boi");
		}
		
	}
}
