package com.disgrace.ddripoff.items;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class TestTrinket extends Trinket {

	public TestTrinket(){
		initTrinket();
	}
	
	@Override
	protected void initTrinket() {
		name="Test Trinket";
		description = "Buffs protection and stun Resistance";
		restriction = null;
		itemRarity = TrinketRarity.COMMON;
		affectedstats = new StatWrapper(new Stat(StatEnumeration.PHYS_PROT,7,true),new Stat(StatEnumeration.STUN_RES,50,true));	
	}
 
}
