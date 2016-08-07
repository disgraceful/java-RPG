package ddripoffmodel;

import java.util.ArrayList;

public class StatWrapper {
	private Hero owner;
	private ArrayList<Stat> stats = new ArrayList<Stat>();

	public StatWrapper(ArrayList<Stat> stats) {
		this.stats = stats;
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

	public ArrayList<Stat> getStatsasArrayList() {
		return stats;
	}

	public Hero getOwner() {
		return owner;
	}

	public void setOwner(Hero owner) {
		this.owner = owner;
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
}
