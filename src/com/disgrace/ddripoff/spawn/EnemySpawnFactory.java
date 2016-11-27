package com.disgrace.ddripoff.spawn;

import com.disgrace.ddripoff.enemies.Enemy;
import com.disgrace.ddripoff.enemies.EnemyClass;

public class EnemySpawnFactory {
	public static Enemy getEnemy(EnemyClass eClass)throws ClassCastException {
		return (Enemy) eClass.getEnemyToSpawn().spawn();	
	}
}
