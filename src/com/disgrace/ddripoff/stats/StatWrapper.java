package com.disgrace.ddripoff.stats;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.spells.DamageType;
import com.disgrace.ddripoff.spells.TemporaryEffectType;

@XmlRootElement
public class StatWrapper implements Serializable {
	private List<Stat> stats = new ArrayList<>();

	public StatWrapper() {
	}

	public StatWrapper(List<Stat> stats) {
		this.stats = stats;
	}

	public StatWrapper(Stat... stats) {
		this.stats.addAll(Arrays.asList(stats));
	}

	public List<Stat> getStats() {
		return stats;
	}

	public void setStats(List<Stat> stats) {
		this.stats = stats;
	}

	public void addStat(Stat stat) {
		stats.add(stat);
	}

	public void addAllStats(Stat... stats) {
		this.stats.addAll(Arrays.asList(stats));
	}

	private boolean checkIfStatExist(StatEnumeration type) {
		for (Stat s : stats) {
			if (s.getType() == type) {
				return true;
			}
		}
		return false;
	}

	public Stat getStatbyName(StatEnumeration type) {
		if (checkIfStatExist(type)) {
			for (Stat s : stats) {
				if (s.getType() == type) {
					return s;
				}
			}
		}
		return null;
	}

	public List<Stat> getStatsasArrayList() {
		return stats;
	}

	public void updateStats(StatWrapper affectedStats) {
		for (Stat c : affectedStats.getStatsasArrayList()) {
			updateStats(c);
		}
	}

	public void updateStats(Stat stat) {
		if (this.checkIfStatExist(stat.type)) {
			Stat curStat = getStatbyName(stat.type);
			int i = curStat.getCurValue();
			if (stat.isAffectingMaxValue) {
				curStat.setMaxValue(curStat.getMaxValue() + stat.getCurValue());
			}
			curStat.setValue(i + stat.getCurValue());
		}
	}

	public static StatWrapper reverseStats(StatWrapper stat) {
		StatWrapper s = new StatWrapper();
		Stat curStat;
		for (Stat c : stat.getStatsasArrayList()) {
			if (c.getCurValue() < 0) {
				curStat = new Stat(c.getType(), Math.abs(c.getCurValue()));
			} else {
				curStat = new Stat(c.getType(), -c.getCurValue());
			}
			s.addStat(curStat);
		}
		return s;
	}

	public boolean isCharDead() {
		return getStatbyName(StatEnumeration.HEALTH).getCurValue() <= 0 && isDeathBlown() ? true : false;
	}

	private boolean isDeathBlown() {
		int chance = new Random().nextInt(101);
		int deathBlowChance = getStatbyName(StatEnumeration.DEATH_RES).getCurValue();
		return chance > deathBlowChance ? true : false;
	}

	public int getProperDeffenceValue(DamageType dType) {
		switch (dType) {
		case PHYSICAL:
			return getStatbyName(StatEnumeration.PHYS_PROT).getCurValue();
		// case MAGICAL:
		// return getStatbyName(StatEnumeration.MAG_PROT).getCurValue();
		// case STRESS:
		// return getStatbyName(StatEnumeration.STRESS_PROT).getCurValue();
		// case LIGHTNING:
		// return getStatbyName(StatEnumeration.LIGHTNING_PROT).getCurValue();
		// case DARK:
		// return getStatbyName(StatEnumeration.DARK_PROT).getCurValue();
		// case FIRE:
		// return getStatbyName(StatEnumeration.FIRE_PROT).getCurValue();
		default:
			System.out.println("Compatible stat doesn't exist");
			return 0;
		}
	}

	public int getProperResistValue(TemporaryEffectType eType) {
		switch (eType) {
		case STUN:
			return getStatbyName(StatEnumeration.STUN_RES).getCurValue();
		case BLEED:
			return getStatbyName(StatEnumeration.BLEED_RES).getCurValue();
		case BLIGHT:
			return getStatbyName(StatEnumeration.BLIGHT_RES).getCurValue();
		case DEBUFF:
			return getStatbyName(StatEnumeration.DEBUFF_RES).getCurValue();
		// case CURSE:
		// return getStatbyName(StatEnumeration.CURSE_RES).getCurValue();
		// case DISEASE:
		// return getStatbyName(StatEnumeration.DISIEASE_RES).getCurValue();
		// case MARK:
		case BUFF:
			return 0;
		default:
			return -1;
		}
	}

	public int getProperMultiplierValue(TemporaryEffectType eType) {
		switch (eType) {
		case STUN:
			return getStatbyName(StatEnumeration.STUN_CHANCE).getCurValue();
		case BLEED:
			return getStatbyName(StatEnumeration.BLEED_CHANCE).getCurValue();
		case BLIGHT:
			return getStatbyName(StatEnumeration.BLIGHT_CHANCE).getCurValue();
		case DEBUFF:
			return getStatbyName(StatEnumeration.DEBUFF_CHANCE).getCurValue();
		// case CURSE:
		// return getStatbyName(StatEnumeration.CURSE_CHANCE).getCurValue();
		// case DISEASE:
		// return getStatbyName(StatEnumeration.DISIEASE_CHANCE).getCurValue();
		// case MARK:
		// return 0;
		case BUFF:
			return 0;
		default:
			return -1;
		}
	}
}
