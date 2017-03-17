package com.disgrace.ddripoff.items;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class TestTrinketCommon extends Trinket {

	public TestTrinketCommon(){
		initTrinket();
	}
	
	@Override
	protected void initTrinket() {
		name="Test Trinket Common";
		description = "Common Buffs protection and stun Resistance";
		restriction = null;
		itemRarity = TrinketRarity.COMMON;
		affectedstats = new StatWrapper(new Stat(StatEnumeration.PHYS_PROT,7,true),new Stat(StatEnumeration.STUN_RES,50,true));	
	}
}
