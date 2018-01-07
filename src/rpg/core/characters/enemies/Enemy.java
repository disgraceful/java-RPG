package rpg.core.characters.enemies;

import java.util.Collections;
import java.util.List;

import rpg.core.characters.shared.Character;
import rpg.core.dungeon.DungeonType;
import rpg.core.game.Pass;
import rpg.core.game.PlayerDecision;
import rpg.core.game.UseSpell;
import rpg.core.spawn.EnemySpawnType;
import rpg.core.spells.Spell;
import rpg.core.utils.CalcHelper;

public abstract class Enemy extends Character implements EnemyAI {
	protected EnemyClass eClass;
	protected EnemySpawnType eSpawnType;
	protected List<EnemySubType> subTypes;
	protected DungeonType areaRestriction;

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

	public DungeonType getAreaRestriction() {
		return areaRestriction;
	}

	public void setAreaRestriction(DungeonType areaRestriction) {
		this.areaRestriction = areaRestriction;
	}

	public boolean isAreaGeneric() {
		return areaRestriction == null;
	}

	@Override
	public Class<Enemy> getCharClass() {
		return Enemy.class;
	}

	@Override
	public PlayerDecision getDecision(List<Character> target) {
		Spell chosenSpell = null;
		for (Spell currentSpell : allAbilities) {
			if (!currentSpell.getAvaliableTargets(this, target).isEmpty()) {
				chosenSpell = currentSpell;
				break;
			}
		}
		if(chosenSpell==null) {
			return new Pass(this);
		}
		
		List<Character> targets = chosenSpell.getAvaliableTargets(this, target);
		if (!chosenSpell.isAOE()) {
			Character loneTarget = targets.get(CalcHelper.randInt(targets.size()));
			targets.clear();
			targets.add(loneTarget);
		}
		return new UseSpell(this,chosenSpell,targets);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
