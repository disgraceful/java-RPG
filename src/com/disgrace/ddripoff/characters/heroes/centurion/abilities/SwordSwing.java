package com.disgrace.ddripoff.characters.heroes.centurion.abilities;

import java.util.ArrayList;

import com.disgrace.ddripoff.abilities.DamageAbility;
import com.disgrace.ddripoff.characters.stats.Stat;
import com.disgrace.ddripoff.characters.stats.StatEnumeration;
import com.disgrace.ddripoff.characters.stats.StatWrapper;

public class SwordSwing extends DamageAbility {

	public SwordSwing() {
		initAbility();
	}
	
	@Override
	public void useAbility(StatWrapper[] targets, StatWrapper user) {
		//super.useAbility(targets, user);
	}
	
	@Override
	protected void initAbility(){
		this.name = "Sword Swing";
		this.description = "Cool description";
		this.defType = StatEnumeration.PHYSPROT;
		this.affectedStats = new StatWrapper(new ArrayList<Stat>(){
			{
				add(new Stat(StatEnumeration.DAMAGE,100,100));
			}
		});
	}
}
