package rpg.core.characters.enemies;

import java.util.List;

import rpg.core.characters.shared.Character;
import rpg.core.dungeon.DungeonType;
import rpg.core.spawn.EnemySpawnType;

public abstract class Enemy extends Character {
	public EnemyClass eClass;
	public EnemySpawnType eSpawnType;
	public List<EnemySubType> subTypes;
	public List<DungeonType> areaRestriction;

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

	public List<DungeonType> getAreaRestriction() {
		return areaRestriction;
	}

	public void setAreaRestriction(List<DungeonType> areaRestriction) {
		this.areaRestriction = areaRestriction;
	}

	@Override
	public Class<Enemy> getCharClass() {
		return Enemy.class;
	}
}
