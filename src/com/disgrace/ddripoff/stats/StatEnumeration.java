package com.disgrace.ddripoff.stats;

public enum StatEnumeration {
	HEALTH("Health"),
	//STRESS("Stress"),
	//CURSE_LEVEL("Curse Level"),
	
	ACC("Accuracy"), //even if dodge 0 acc cant be more than 90%
	CRIT_CHANCE("Critical Chance"),
	
	DAMAGE("Damage"),
	//STRENGTH("Strength"),
	//DEXTERITY("Dexterity"),
	//INTELIGENCE("Inteligence"),
	//FAITH("Faith"),
	
	MOVE_SPELL_POSITION("Position"),
	STUN_CHANCE("Stun Chance"),
	MOVE_CHANCE("Move Chance"),
	BLEED_CHANCE("Bleed Chance"),
	BLIGHT_CHANCE("Blight Chance"),
	DEBUFF_CHANCE("Debuff Chance"),
	
	ACC_MOD("Accuracy Modifier"),
	DAMAGE_MOD("Damage Modifier"),
	CRIT_MOD("Critical Strike Modifier"),
	RANGE_MOD("Range Ability Damage Modifier"),
	MELEE_MOD("Melee Ability Damage Modifier"),
	PHYS_MOD("Physical Damage Modifier"),
	//MAG_MOD("Magical Damage Modifier"),
	//LIGHTNING_MOD("Lightning Damage Modifier"),
	//FIRE_MOD("Fire Damage Modifier"),
	//DARK_MOD("Dark Damage Modifier"),

	SPEED("Speed"  ),
	//TRAP_DISARM_CHANCE("Trap disarm Chance"),
	//VIRTUE_CHANCE("Virtue Chance"),
	DODGE("Dodge"),
	
	BLEED_RES("Bleed Resistance"),
	BLIGHT_RES("Blight Resistance"),
	STUN_RES("Stun Resistance"),
	//CURSE_RES("Curse Resistance"),
	MOVE_RES("Move Resistance"),
	//DISIEASE_RES("Disease Resistance"),
	DEBUFF_RES("Debuff Resistance"), 
	DEATH_RES("Deathblow Resistance"),

	PHYS_PROT("Physical Protection");
	//MAG_PROT("Physical Protection"),
	//STRESS_PROT("Stress Protection"),
	//LIGHTNING_PROT("Lightning Protection"),
	//FIRE_PROT("Fire Protection"),
	//DARK_PROT("Dark Protection"),
	
	private String name;
	private StatEnumeration(String name){
		this.name= name;

	}
}
