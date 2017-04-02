package com.disgrace.ddripoff.items;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;
@XmlRootElement
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
		affectedstats = new StatWrapper(new Stat(StatEnumeration.PHYS_PROT,7,true),new Stat(StatEnumeration.STUN_RES,50,true));	
	}
}
