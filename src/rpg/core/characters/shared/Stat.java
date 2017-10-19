package rpg.core.characters.shared;

public class Stat {
	StatEnum type;
	int baseValue;
	int curValue;
	int maxValue;
	boolean affectsMaxValue;
	boolean isTemporary;
	StatAffectStrategy statStrategy;

	public Stat(StatEnum type, int value) {
		this.type = type;
		curValue = value;
		baseValue = value;
	}

	public Stat(StatEnum type, int curvalue, boolean affectsMaxValue, StatAffectStrategy strat) {
		this(type, curvalue);
		this.affectsMaxValue = affectsMaxValue;
		isTemporary = true;
		statStrategy = strat;
	}

	public Stat(StatEnum type, int curvalue, int maxvalue) {
		this(type, curvalue);
		maxValue = maxvalue;
	}

	public Stat() {
	}

	public boolean isTemporary() {
		return isTemporary;
	}

	public void setTemporary(boolean isTemporary) {
		this.isTemporary = isTemporary;
	}

	public void setType(StatEnum type) {
		this.type = type;
	}

	public void setBaseValue(int baseValue) {
		this.baseValue = baseValue;
	}

	public void setAffectingMaxValue(boolean isAffectingMaxValue) {
		this.affectsMaxValue = isAffectingMaxValue;
	}

	public StatEnum getType() {
		return type;
	}

	public int getBaseValue() {
		return baseValue;
	}

	public int getCurValue() {
		return curValue;
	}

	public void setMaxValue(int value) {
		maxValue = value;
	}

	public void setValue(int value) {
		curValue = countValue(value);
	}

	public int getMaxValue() {
		return maxValue;
	}

	public boolean getIsAffectingMaxValue() {
		return affectsMaxValue;
	}

	public int getValueDifference() {
		return maxValue - curValue;
	}

	public StatAffectStrategy getStatStrategy() {
		return statStrategy;
	}

	public void setStatStrategy(StatAffectStrategy statStrategy) {
		this.statStrategy = statStrategy;
	}

	private int countValue(int value) {
		int setValue = 0;
		if (value > maxValue && maxValue != 0) {
			setValue = maxValue;
			return setValue;
		} else if (value < 0 && !isTemporary) {
			return setValue;
		}
		setValue = value;
		return setValue;
	}

}
