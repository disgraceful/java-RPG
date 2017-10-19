package rpg.core.characters.shared;

public enum StatEnum {
	HEALTH("Health"),
	STRESS("Stress"),
	CURSE_LEVEL("Curse Level"),
	
	ACC("Accuracy"), //even if dodge 0 acc cant be more than 90%
	CRIT_CHANCE("Critical Chance"),
	DAMAGE("Damage"),
	PROT("Physical Protection"),
	
	MOVE_SPELL_POSITION("Position"),
	STUN_CHANCE("Stun Chance"),
	MOVE_CHANCE("Move Chance"),
	BLEED_CHANCE("Bleed Chance"),
	BLIGHT_CHANCE("Blight Chance"),
	DEBUFF_CHANCE("Debuff Chance"),
	CURSE_CHANCE("Curse Chance"),
	DISEASE_CHANCE("Disease Chance"),
	
	ACC_MOD("Accuracy Modifier"),
	DAMAGE_MOD("Damage Modifier"),
	CRIT_MOD("Critical Strike Modifier"),
	RANGE_MOD("Range Ability Damage Modifier"),
	MELEE_MOD("Melee Ability Damage Modifier"),
		
	SPEED("Speed"  ),
	TRAP_DISARM_CHANCE("Trap disarm Chance"),
	VIRTUE_CHANCE("Virtue Chance"),
	DODGE("Dodge"),
	
	BLEED_RES("Bleed Resistance"),
	BLIGHT_RES("Blight Resistance"),
	STUN_RES("Stun Resistance"),
	CURSE_RES("Curse Resistance"),
	MOVE_RES("Move Resistance"),
	DISEASE_RES("Disease Resistance"),
	DEBUFF_RES("Debuff Resistance"), 
	DEATH_RES("Deathblow Resistance"),
	STRESS_RES("Stress Resistance"),

	DARKIN_DMG_MOD("Darkin Damage Modifier"),
	HUMAN_DMG_MOD("Human Damage Modifier"),
	VOIDBORN_DMG_MOD("Voidborn Damage Modifier"),
	BEHEMOTH_DMG_MOD("Behemoth Damage Modifier"),
	DRAGON_DMG_MOD("Dragon Damage Modifier"),
	
	MARK_DMG_MOD("Marked Target Damage Modifier");
	
	private String name;
	
	private StatEnum(String name){
		this.name= name;
	}
}
