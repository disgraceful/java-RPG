package com.disgrace.ddripoff.outcast_abilities;

import java.util.ArrayList;

import com.disgrace.ddripoff.abilities.DamageAbility;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class CutTheThroat extends DamageAbility {
	@Override
	public void useAbility(StatWrapper[] targets, StatWrapper user) {
		//super.useAbility(targets, user);
	}
	
	@Override
	protected void initAbility(){
		this.name = "Cut the throat Swing";
		this.description = "Cool description";
		this.defType = StatEnumeration.PHYSPROT;
		this.affectedStats = new StatWrapper(new ArrayList<Stat>(){
			{
				add(new Stat(StatEnumeration.DAMAGE,100,100));
			}
		});
	}
}
