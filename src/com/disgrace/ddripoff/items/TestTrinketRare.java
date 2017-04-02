package com.disgrace.ddripoff.items;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;
@XmlRootElement
public class TestTrinketRare  extends Trinket {

	public TestTrinketRare(){
		initItem();
	}
	
	@Override
	protected void initItem() {
		super.initItem();
		name="Test Trinket Rare";
		description = "Rare Buffs protection and stun Resistance";
		restriction = null;
		itemRarity = TrinketRarity.RARE;
		affectedstats = new StatWrapper(new Stat(StatEnumeration.PHYS_PROT,7,true),new Stat(StatEnumeration.STUN_RES,50,true));	
	}
}


