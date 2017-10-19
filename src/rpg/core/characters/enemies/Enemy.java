package rpg.core.characters.enemies;

import java.util.List;

import rpg.core.characters.shared.Character;

public abstract class Enemy extends Character {
	protected EnemyClass eClass;
	protected List<EnemySubType> subTypes;

	public EnemyClass getEnemyClass() {
		return eClass;
	}

	public EnemyClass geteClass() {
		return eClass;
	}

	public void seteClass(EnemyClass eClass) {
		this.eClass = eClass;
	}

	public List<EnemySubType> getSubTypes() {
		return subTypes;
	}

	public void setSubTypes(List<EnemySubType> subTypes) {
		this.subTypes = subTypes;
	}

	@Override
	public Class<Enemy> getCharClass() {
		return Enemy.class;
	}
}
