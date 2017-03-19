package com.disgrace.ddripoff.items;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

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
		affectedstats = new StatWrapper(new Stat(StatEnumeration.PHYS_PROT,7,true),new Stat(StatEnumeration.STUN_RES,50,true));	
	}
}
