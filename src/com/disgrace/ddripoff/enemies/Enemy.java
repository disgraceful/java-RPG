package com.disgrace.ddripoff.enemies;

import com.disgrace.ddripoff.characters.shared.Character;
import com.disgrace.ddripoff.enemies.EnemySubType;
import com.disgrace.ddripoff.heroes.Hero;
import com.disgrace.ddripoff.spells.SpellEnum;

public abstract class Enemy extends Character {
	protected EnemyClass eClass;
	
	@Override
	public void useAbility(SpellEnum ability, Character[] targets) {
		ability.castSpellCombo(targets, this);	
	}

	public EnemyClass getEnemyClass(){
		return eClass;
	}
}
