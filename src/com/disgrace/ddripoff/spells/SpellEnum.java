package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.characters.shared.Character;

public enum SpellEnum {
	CENTURION_SWORD_SWING(new CenturionSwordSwing()),
	CENTURION_SHIELD_SLAM(new CenturionShieldSlamDamage(),new CenturionShieldSlamStun(),new CenturionShieldSlamMove());
	
	private Spell[] spells;
	private SpellEnum( Spell ... spells) {
		this.spells = spells;
	}
	
	public void castSpellCombo(Character[] targets, Character caller){
		for(Spell s : spells){
			s.useSpell(targets, caller);
		}
	}
}
