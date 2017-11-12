package rpg.core.items.trinkets;

import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatAffectStrategy;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;

public class TestTrinketCommon extends Trinket {

	public TestTrinketCommon(){
		initItem();
	}
	
	@Override
	protected void initItem() {
		super.initItem();
		name="Test Trinket Common";
		description = "Common Buffs protection and stun Resistance";
		restriction = null;
		itemRarity = TrinketRarity.COMMON;
		affectedstats = new StatWrapper(new Stat(StatEnum.PROT,7,true,StatAffectStrategy.SUMMING_UP),new Stat(StatEnum.STUN_RES,50,true,StatAffectStrategy.SUMMING_UP));	
	}
}
