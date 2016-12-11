package com.disgrace.ddripoff.enemies;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.enemies.EnemySubType;
import com.disgrace.ddripoff.heroes.Hero;

public abstract class Enemy extends Character {
	protected EnemyClass eClass;
	
	public EnemyClass getEnemyClass(){
		return eClass;
	}
}
