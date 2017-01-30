package com.disgrace.ddripoff.spells;

import java.util.ArrayList;

import com.disgrace.ddripoff.characters.heroes.HeroClass;
import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class CenturionShieldSlamStun extends StunSpell {
	public CenturionShieldSlamStun() {
		initSpell();
	}

	@Override
	public void initSpell() {
		restrictionClass = HeroClass.CENTURION;
		spellType = TargetType.ENEMY;
		range = RangeType.MELEE;
		abilityDuration = 1;
		currentDuration = abilityDuration;
		currentDuration = abilityDuration;
		effectType = TemporaryEffectType.STUN;
		abilityStats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.STUN_CHANCE, 110, 220));
			}
		});
		affectedStats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.IS_STUNNED, 1, false));
			}
		});
		callerRestrictedPos.add(0);

		targetsRestrictedPos.add(0);
		targetsRestrictedPos.add(1);
	}


}
