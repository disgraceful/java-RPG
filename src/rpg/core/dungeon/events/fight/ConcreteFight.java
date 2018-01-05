package rpg.core.dungeon.events.fight;

import rpg.core.characters.shared.Party;
import rpg.core.items.Loot;

public class ConcreteFight extends Fight{

	public ConcreteFight(Party enemyParty,Loot loot) {
		super();
		this.enemyParty= enemyParty;
		this.loot = loot;
	}
	
	@Override
	public void initEvent() {		
	}

}
