package com.disgrace.ddripoff.spells;

import java.util.ArrayList;

import com.disgrace.ddripoff.enemies.EnemyClass;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class OutcastSwordsmanSlashOfExile extends DamageSpell {
	public OutcastSwordsmanSlashOfExile() {
		initSpell();
	}

	@Override
	public void initSpell() {
		name = "Slash Of Exile";
		description = "Cool description";
		restrictionClass = EnemyClass.OUTCAST_SWORDSMAN;
		damageType = DamageType.PHYS;
		range = RangeType.MELEE;
		spellType = TargetType.ENEMY;
		abilityStats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.ACC_MOD, 90, 100));
				add(new Stat(StatEnumeration.DAMAGE_MOD, 110, 100));
				add(new Stat(StatEnumeration.CRIT_MOD, 5, 100));
			}
		});

		callerRestrictedPos.add(0);
		callerRestrictedPos.add(1);
		callerRestrictedPos.add(2);

		targetsRestrictedPos.add(0);
		targetsRestrictedPos.add(1);
		targetsRestrictedPos.add(2);

	}
}