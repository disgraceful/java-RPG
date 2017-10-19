package rpg.core.items;

import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatAffectStrategy;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;

public class TestTrinketUncommon extends Trinket {

	public TestTrinketUncommon(){
		initItem();
	}
	
	@Override
	protected void initItem() {
		super.initItem();
		name="Test Trinket Uncommon";
		description = "Uncommon Buffs protection and stun Resistance";
		restriction = null;
		itemRarity = TrinketRarity.UNCOMMON;
		affectedstats = new StatWrapper(new Stat(StatEnum.PROT,7,true,StatAffectStrategy.SUMMING_UP),new Stat(StatEnum.STUN_RES,50,true,StatAffectStrategy.SUMMING_UP));	
	}
}
