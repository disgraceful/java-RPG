package com.disgrace.ddripoff.spells;

import java.util.ArrayList;

import com.disgrace.ddripoff.characters.enemies.EnemyClass;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class TestBuff extends BuffSpell {
	public TestBuff() {
		initSpell();
	}

	@Override
	public void initSpell() {
		range = RangeType.RANGE;
		spellOrientation = effectType == TemporaryEffectType.BUFF ? TargetType.ALLY : TargetType.ENEMY;
		abilityDuration = 3;
		currentDuration = abilityDuration;
		effectType = TemporaryEffectType.BUFF;
		abilityStats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.DAMAGE, 5, true));
				add(new Stat(StatEnumeration.PHYS_PROT, 5, true));
			}
		});

		callerRestrictedPos.add(0);
		callerRestrictedPos.add(1);
		callerRestrictedPos.add(2);
		callerRestrictedPos.add(3);

		targetsRestrictedPos.add(0);
		targetsRestrictedPos.add(1);
		targetsRestrictedPos.add(2);
		targetsRestrictedPos.add(3);
	}
}
