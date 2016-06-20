package ddripoffmodel;

public class Stat {
	private String name;
	private int curValue;
	private int maxValue;
	private boolean isAffectingMaxValue;
	private boolean isPrimordial;

	public String getName() {
		return name;
	}

	public Stat(String name, int curvalue, int maxvalue) {
		this.name = name;
		curValue = curvalue;
		maxValue = maxvalue;
		isPrimordial = true;
	}

	public Stat(String name, int value, boolean istempstat) {
		this.name = name;
		curValue = value;
		isAffectingMaxValue = istempstat;
		istempstat = false;
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
		return isAffectingMaxValue;
	}

	public int getHpDifference() {
		return maxValue - curValue;
	}

	private int countValue(int value) {
		int setValue = 0;
		if (value > maxValue && maxValue != 0) {
			setValue = maxValue;
			return setValue;
		} else if (value < 0 && isPrimordial) {
			if (name == "Health") {
				// hero rip;
			}
			return setValue;
		}
		setValue = value;
		return setValue;
	}
}
