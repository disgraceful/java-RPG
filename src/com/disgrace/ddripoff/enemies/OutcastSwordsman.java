package com.disgrace.ddripoff.enemies;

import java.util.ArrayList;

import com.disgrace.ddripoff.spawn.SpawnableEnemy;
import com.disgrace.ddripoff.spells.SpellEnum;
import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

public class OutcastSwordsman extends Enemy implements SpawnableEnemy {

	public OutcastSwordsman() {
		name="Outcast Swordsman";
		init();
	}

	@Override
	public SpawnableEnemy spawn() {
		return new OutcastSwordsman();
	}

	@Override
	protected void init() {
		eClass = EnemyClass.OUTCAST_SWORDSMAN;
		this.stats = new StatWrapper(new ArrayList<Stat>() {
			{
				add(new Stat(StatEnumeration.HEALTH, 15, 30));
				add(new Stat(StatEnumeration.DODGE, 7, 50));
				add(new Stat(StatEnumeration.MAG_PROT, 0, 100));
				add(new Stat(StatEnumeration.PHYS_PROT, 0, 100));
				add(new Stat(StatEnumeration.DAMAGE, 9, 100));
				add(new Stat(StatEnumeration.SPEED, 6, 20));
				add(new Stat(StatEnumeration.ACC, 7, 100));
				add(new Stat(StatEnumeration.CRIT_CHANCE, 0, 100));
				add(new Stat(StatEnumeration.STUN_RES, 40, 100));
				add(new Stat(StatEnumeration.BLIGHT_RES, 25, 100));
				add(new Stat(StatEnumeration.DEATH_RES, 0, 100));
				add(new Stat(StatEnumeration.MOVE_RES, 10, 100));
				add(new Stat(StatEnumeration.BLEED_RES, 30, 100));
				add(new Stat(StatEnumeration.DEBUFF_RES, 40, 100));
			}
		});
		allAbilities.add(SpellEnum.CENTURION_SWORD_SWING);
		allAbilities.add(SpellEnum.CENTURION_SWORD_SWING);
	}
}
