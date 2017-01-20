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
		restrictionClass = HeroClass.CENTURION;
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
				add(new Stat(StatEnumeration.IS_STUNNED, -1, 1));
			}
		});
		callerRestrictedPos.add(0);

		targetsRestrictedPos.add(0);
		targetsRestrictedPos.add(1);
	}

	@Override
	public void onTick(Character target) {
		if (currentDuration > 0) {
			currentDuration--;
			return;
		}
		onExpire(target);
	}

	@Override
	public void onExpire(Character target) {
		target.cleanseTempEffect(this);
	}
}
