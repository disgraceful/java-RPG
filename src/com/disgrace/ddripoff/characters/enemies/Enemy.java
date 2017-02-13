package com.disgrace.ddripoff.characters.enemies;

import com.disgrace.ddripoff.characters.shared.Character;

public abstract class Enemy extends Character {
	protected EnemyClass eClass;
	
	public EnemyClass getEnemyClass(){
		return eClass;
	}
	
	@Override
	public Class<Enemy> getCharClass(){
		return Enemy.class;
	}
}
