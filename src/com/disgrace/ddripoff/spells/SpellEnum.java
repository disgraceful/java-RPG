package com.disgrace.ddripoff.spells;

import com.disgrace.ddripoff.characters.shared.Character;

public enum SpellEnum {
	CENTURION_SWORD_SWING("Sword Swing", "Cool description", new CenturionSwordSwing()), CENTURION_SHIELD_SLAM(
			"Shield Slam", "Cool description", new CenturionShieldSlamMove(), new CenturionShieldSlamStun(),
			new CenturionShieldSlamDamage()), OUTCAST_SWORDSMAN_SLASH_OF_EXILE("Slash of Exile", "Cool description",
					new OutcastSwordsmanSlashOfExile()), OUTCAST_SWORDSMAN_VILE_ATTACK("Vile Attack",
							"Cool description", new OutcastSwordsmanVileAttackBleed(),
							new OutcastSwordsmanVileAttackBleed()), GENERAL_HEAL("Heal Test Spell", "Cool desc",
									new TestHeal());

	private String name;
	private String description;
	private Spell[] spells;

	private SpellEnum(String name, String description, Spell... spells) {
		this.spells = spells;
		this.name = name;
		this.description = description;
	}

	public void castSpell(Character[] targets, Character caller) {
		for (Spell s : spells) {
			s.useSpell(targets, caller);
		}
	}

	public Spell getSpellClass() {
		return spells[0];
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
