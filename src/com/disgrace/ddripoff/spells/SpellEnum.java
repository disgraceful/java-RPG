package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.characters.shared.Character;

public enum SpellEnum {
	CENTURION_SWORD_SWING(new CenturionSwordSwing());
	
//	SPELL1("Combo", new MoveSpell() ){
//		@Override
//		public void castSpellCombo(Character[] targets, Character caller) {
//			// TODO Auto-generated method stub
//			super.castSpellCombo(targets, caller);
//		}
//	},
//	SPELL2("Combo", new MoveSpell() );
	
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
