package rpg.core.spells.instances;

import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;
import rpg.core.spells.AttackType;
import rpg.core.spells.DOT;
import rpg.core.spells.OffensiveSpell;
import rpg.core.spells.SpellOrientation;
import rpg.core.spells.SpellPositionWrapper;
import rpg.core.spells.SpellTargetQuantity;
import rpg.core.spells.TemporaryEffectType;

public class DishonoredOpenWounds extends OffensiveSpell {
	public DishonoredOpenWounds() {
		name = "Open Wounds";
		description = "Dishonorable man with dishonorable tricks!";
		orientation = SpellOrientation.OFFENSIVE;
		attackType = AttackType.MELEE;
		targetQuantity = SpellTargetQuantity.MULTIPLE;
		abilityStats = new StatWrapper(new Stat(StatEnum.DAMAGE_MOD, -60), new Stat(StatEnum.ACC, 70),
				new Stat(StatEnum.CRIT_MOD, 5));
		applyingEffects.add(new DOT(3,
				new StatWrapper(new Stat(StatEnum.BLEED_CHANCE, 120), new Stat(StatEnum.HEALTH, -1)),
				TemporaryEffectType.BLEED));
		callerRequiredPos = new SpellPositionWrapper(0, 1);
		targetRequiredPos = new SpellPositionWrapper(1, 2);
	}
}
