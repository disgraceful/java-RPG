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

public class DishonoredBloodyRedemption extends OffensiveSpell {
	public DishonoredBloodyRedemption() {
		name = "Bloody Redemption";
		description = "The guilty will pay the price!";
		orientation = SpellOrientation.OFFENSIVE;
		attackType = AttackType.MELEE;
		targetQuantity = SpellTargetQuantity.SINGLE;
		abilityStats = new StatWrapper(new Stat(StatEnum.DAMAGE_MOD, 0), new Stat(StatEnum.ACC, 65),
				new Stat(StatEnum.CRIT_MOD, 0));
		applyingEffects.add(new DOT(3,new StatWrapper(new Stat(StatEnum.BLEED_CHANCE, 120),new Stat(StatEnum.HEALTH, -1)),TemporaryEffectType.BLEED));
		callerRequiredPos = new SpellPositionWrapper(0, 1);
		targetRequiredPos = new SpellPositionWrapper(1, 2);
	}
}
