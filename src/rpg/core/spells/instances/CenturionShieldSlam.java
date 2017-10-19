package rpg.core.spells.instances;

import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;
import rpg.core.spells.AttackType;
import rpg.core.spells.Move;
import rpg.core.spells.OffensiveSpell;
import rpg.core.spells.SpellOrientation;
import rpg.core.spells.SpellPositionWrapper;
import rpg.core.spells.SpellTargetQuantity;
import rpg.core.spells.Stun;


public class CenturionShieldSlam extends OffensiveSpell {

	public CenturionShieldSlam() {
		name = "Shield Slam";
		description = "Centurion slams his shield, stunning and knocking enemy back!";
		orientation = SpellOrientation.OFFENSIVE;
		attackType = AttackType.MELEE;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnum.DAMAGE_MOD, -40), new Stat(StatEnum.ACC, 75),
				new Stat(StatEnum.CRIT_MOD, 0));
		applyingEffects.add(new Stun(new StatWrapper(new Stat(StatEnum.STUN_CHANCE, 110))));
		applyingEffects.add(new Move(new StatWrapper(new Stat(StatEnum.MOVE_CHANCE, 100),
				new Stat(StatEnum.MOVE_SPELL_POSITION, -1))));
		callerRequiredPos = new SpellPositionWrapper(1);
		targetRequiredPos = new SpellPositionWrapper(0, 1);
	}



}
