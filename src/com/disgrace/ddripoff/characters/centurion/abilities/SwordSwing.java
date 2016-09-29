package com.disgrace.ddripoff.characters.centurion.abilities;

import java.util.ArrayList;

import com.disgrace.ddripoff.abilities.DamageAbility;
import com.disgrace.ddripoff.characters.Stat;
import com.disgrace.ddripoff.characters.StatEnumeration;
import com.disgrace.ddripoff.characters.StatWrapper;

public class SwordSwing extends DamageAbility {

	public SwordSwing() {
		initAbility();
	}
	
	public void useAbility(StatWrapper[] targets, StatWrapper user) {
		super.useAbility(targets, user);
	}
	
	private void initAbility(){
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
