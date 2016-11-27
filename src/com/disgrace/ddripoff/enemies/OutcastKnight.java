package com.disgrace.ddripoff.enemies;

import com.disgrace.ddripoff.spawn.SpawnableEnemy;

public class OutcastKnight extends Enemy implements SpawnableEnemy {

	@Override
	public SpawnableEnemy  spawn() {
		return new OutcastKnight();
	}

	@Override
	protected void init() {
		eClass = EnemyClass.OUTCAST_KNIGHT;
	}

}
