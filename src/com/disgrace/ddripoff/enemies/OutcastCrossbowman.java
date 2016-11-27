package com.disgrace.ddripoff.enemies;

import com.disgrace.ddripoff.spawn.SpawnableEnemy;

public class OutcastCrossbowman extends Enemy implements SpawnableEnemy {

	@Override
	public SpawnableEnemy spawn() {
		return new OutcastCrossbowman();
	}

	@Override
	protected void init() {
		eClass = EnemyClass.OUTCAST_CROSSBOWMAN;
	}

}
