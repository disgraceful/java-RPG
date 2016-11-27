package com.disgrace.ddripoff.enemies;

import com.disgrace.ddripoff.spawn.SpawnableEnemy;

public class OutcastSwordsman extends Enemy implements SpawnableEnemy{

	@Override
	public SpawnableEnemy spawn() {
		return new OutcastSwordsman();
	}

	@Override
	protected void init() {
		eClass = EnemyClass.OUTCAST_SWORDSMAN;
		
	}

}
