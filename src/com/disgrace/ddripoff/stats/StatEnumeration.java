package com.disgrace.ddripoff.stats;

public enum StatEnumeration {
	HEALTH("Health",StatSpecification.DEF_STAT),
	STRESS("Stress",StatSpecification.DEF_STAT),
	
	DAMAGE("Damage",StatSpecification.DAMAGE_STAT),
	ACC("Accuracy",StatSpecification.DAMAGE_STAT), //even if dodge 0 acc cant be more than 90%
	CRIT_CHANCE("Critical Chance",StatSpecification.DAMAGE_STAT),
	
	DAMAGE_MOD("Damage Modifier",StatSpecification.STAT_MOD),
	ACC_MOD("Accuracy Modifier",StatSpecification.STAT_MOD),
	CRIT_MOD("Critical Strike Modifier",StatSpecification.STAT_MOD),

	SPEED("Speed",StatSpecification.UTILITY_STAT),
	POSITION("Position",StatSpecification.UTILITY_STAT),
	TRAP_DISARM_CHANCE("Trap disarm Chance",StatSpecification.UTILITY_STAT),
	VIRTUE_CHANCE("Virtue Chance",StatSpecification.UTILITY_STAT),
	DODGE("Dodge",StatSpecification.UTILITY_STAT),
	
	BLEED_RES("Bleed Resistance",StatSpecification.RESIST_STAT),
	BLIGHT_RES("Blight Resistance",StatSpecification.RESIST_STAT),
	STUN_RES("Stun Resistance",StatSpecification.RESIST_STAT),
	CURSE_RES("Curse Resistance",StatSpecification.RESIST_STAT),
	MOVE_RES("Move Resistance",StatSpecification.RESIST_STAT),
	DISIEASE_RES("Disease Resistance",StatSpecification.RESIST_STAT),
	DEBUFF_RES("Debuff Resistance",StatSpecification.RESIST_STAT), 
	DEATH_RES("Deathblow Resistance",StatSpecification.RESIST_STAT),
	
	PHYS_PROT("Physical Protection",StatSpecification.PROT_STAT),
	MAG_PROT("Physical Protection",StatSpecification.PROT_STAT),
	STRESS_PROT("Stress Protection",StatSpecification.PROT_STAT);
	
	private String name;
	private StatSpecification specification;
	private StatEnumeration(String name, StatSpecification spec){
		this.name= name;
		specification = spec;
	}
}

enum StatSpecification{
	DEF_STAT, DAMAGE_STAT, UTILITY_STAT, RESIST_STAT,PROT_STAT, STAT_MOD;
}
