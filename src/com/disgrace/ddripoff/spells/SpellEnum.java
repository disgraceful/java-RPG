package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.characters.shared.Character;

public enum SpellEnum {
	CENTURION_SWORD_SWING(new CenturionSwordSwing()),
	CENTURION_SHIELD_SLAM(new CenturionShieldSlamDamage(),new CenturionShieldSlamStun(),new CenturionShieldSlamMove()),
	OUTCAST_SWORDSMAN_SLASH_OF_EXILE(new OutcastSwordsmanSlashOfExile());
	
	private Spell[] spells;
	private SpellEnum( Spell ... spells) {
		this.spells = spells;
	}
	
	public void castSpell(Character[] targets, Character caller){
		for(Spell s : spells){
			s.useSpell(targets, caller);
		}
	}
	
	public  Spell getSpellClass(){
		return spells[0];
	}
}
