package com.disgrace.ddripoff.stats;

import java.util.ArrayList;
import java.util.List;

import com.disgrace.ddripoff.spells.DamageType;
import com.disgrace.ddripoff.spells.TemporaryEffectType;

public class StatWrapper {
	private List<Stat> stats = new ArrayList<Stat>();

	public StatWrapper(List<Stat> list) {
		this.stats = list;
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
			return null;
		}
		return null;
	}

	public List<Stat> getStatsasArrayList() {
		return stats;
	}

	public void updateStats(StatWrapper affectedstats) {
		for (Stat c : affectedstats.getStatsasArrayList()) {
			if (this.checkIfStatExist(c.getType())) {
				Stat curStat = this.getStatbyName((c.getType()));
				int i = curStat.getCurValue();
				if (c.getIsAffectingMaxValue()) {
					curStat.setMaxValue(curStat.getMaxValue() + c.getCurValue());
				}
				curStat.setValue(i + c.getCurValue());
			}
		}
	}

	public static void reverseStatsValue(StatWrapper stat) {
		for (Stat c : stat.getStatsasArrayList()) {
			if (c.getCurValue() < 0) {
				c.setValue(Math.abs(c.getCurValue()));
			} else {
				c.setValue(-c.getCurValue());
			}
		}
	}
	
	public int getProperDeffenceValue(DamageType dType) {
		switch (dType) {
		case PHYS:
			return getStatbyName(StatEnumeration.PHYS_PROT).getCurValue();
		case MAGICAL:
			return getStatbyName(StatEnumeration.MAG_PROT).getCurValue();
		case STRESS:
			return getStatbyName(StatEnumeration.STRESS_PROT).getCurValue();
		default:
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
		case CURSE:
			return getStatbyName(StatEnumeration.CURSE_RES).getCurValue();
		case DISEASE:
			return getStatbyName(StatEnumeration.DISIEASE_RES).getCurValue();
		case MARK:
			return 0;
		case BUFF:
			return 0;
		default:
			return -1;
		}
	}

}
