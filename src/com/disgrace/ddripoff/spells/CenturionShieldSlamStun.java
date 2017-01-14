package com.disgrace.ddripoff.spells;

import java.util.ArrayList;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.heroes.HeroClass;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class CenturionShieldSlamStun extends TemporarySpell {
	public CenturionShieldSlamStun() {
		initSpell();
	}

	@Override
	public void initSpell() {
		name = "Shield Slam";
		description = "Cool description";
		restrictionClass = HeroClass.CENTURION;
		range = RangeType.MELEE;
		abilityDuration =1;
		currentDuration = abilityDuration;

		abilityStats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.STUN_CHANCE, 110, 220));
			}
		});

		callerRestrictedPos.add(new Integer(1));

		targetsRestrictedPos.add(new Integer(1));
		targetsRestrictedPos.add(new Integer(2));
	}

	@Override
	public void onTick(Character target) {
		if(currentDuration>0){
			currentDuration--;
		}
		
	}

	@Override
	public void onExpire(Character target) {
		// TODO Auto-generated method stub
		
	}
}
