package com.disgrace.ddripoff.abilities;

import java.util.ArrayList;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;
import com.disgrace.ddripoff.characters.Character;;

public class SwordSwing extends DamageAbility {

	public SwordSwing() {
		initAbility();
	}
	
	@Override
	public void useAbility(Character[] targets, Character caller) {
		super.useAbility(targets, caller);
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
