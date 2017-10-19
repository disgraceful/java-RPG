package rpg.core.characters.shared;

import java.util.ArrayList;
import java.util.List;

import rpg.core.characters.enemies.Enemy;
import rpg.core.spells.Spell;
import rpg.core.spells.TemporaryEffect;
import rpg.core.spells.TemporaryEffectType;

public abstract class Character implements Comparable<Character> {
	protected String name;
	protected StatWrapper stats;

	protected TempEffectsWrapper tempEffects = new TempEffectsWrapper();
	protected List<Spell> allAbilities = new ArrayList<>();
	protected Party party;

	public List<Spell> getAllAbilities() {
		return allAbilities;
	}

	public void setAllAbilities(List<Spell> allAbilities) {
		this.allAbilities = allAbilities;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStats(StatWrapper stats) {
		this.stats = stats;
	}

	public void setTempEffects(TempEffectsWrapper tempEffects) {
		this.tempEffects = tempEffects;
	}

	public String getName() {
		return name;
	}

	public StatWrapper getStatWrapper() {
		return stats;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public TempEffectsWrapper getEffectsWrapper() {
		return tempEffects;
	}

	public List<TemporaryEffect> getTempEffects() {
		return tempEffects.getTempEffects();
	}

	public StatWrapper getStats() {
		return stats;
	}

	public int getPosition() {
		return party == null ? -1 : party.getPosition(this);
	}

	public Stat getStatbyName(StatEnum type) {
		return stats.getStatbyName(type);
	}

	public int getProperResistValue(TemporaryEffectType type) {
		return stats.getProperResistValue(type);
	}

	public int getProperMultiplierValue(TemporaryEffectType type) {
		return stats.getProperMultiplierValue(type);
	}

	public int getProperSpecificDamageMod(Enemy enemy) {
		return stats.getProperSpecificDamageMod(enemy);
	}

	public void addEffect(TemporaryEffect effect) {
		tempEffects.addEffect(effect);
	}

	public void move(int newposition) {
		party.reposition(this, newposition);
	}

	public boolean isCharDead() {
		return stats.isCharDead();
	}

	public void charDied() {
		party.removeMember(this);
		System.out.println(name + "RIP ");
	}

	public boolean isCharStunned() {
		return tempEffects.isStunned();
	}

	public boolean isCharDiseased() {
		return tempEffects.isDiseased();
	}

	public boolean isCharCursed() {
		return tempEffects.isCursed();
	}

	public abstract Class<?> getCharClass();

	public void useAbility(Spell ability, Character... targets) {
		ability.useSpell(this, targets);
	}

	@Override
	public int compareTo(Character c1) {
		int comparespeed = c1.getStatWrapper().getStatbyName(StatEnum.SPEED).getCurValue();
		return comparespeed - stats.getStatbyName(StatEnum.SPEED).getCurValue();
	}

	@Override
	public String toString() {
		return name;
	}

	public void updateStats(StatWrapper affectedStats) {
		if (affectedStats == null) {
			return;
		}
		stats.updateStats(affectedStats);
	}

	public void updateStats(Stat stat) {
		if (stat == null) {
			return;
		}
		stats.updateStats(stat);
	}

}