package com.disgrace.ddripoff.items;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class TestTrinketAbyssmal  extends Trinket {

	public TestTrinketAbyssmal(){
		initItem();
	}
	
	@Override
	protected void initItem() {
		super.initItem();
		name="Test Trinket Abyssmal";
		description = "Abyssmal Buffs protection and stun Resistance";
		restriction = null;
		itemRarity = TrinketRarity.COMMON;
		affectedstats = new StatWrapper(new Stat(StatEnumeration.PHYS_PROT,7,true),new Stat(StatEnumeration.STUN_RES,50,true));	
	}
}