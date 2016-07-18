package ddripoffmodel;

public class Stat {
	private StatEnumeration type;
	private int baseValue;
	private int curValue;
	private int maxValue;
	private boolean isAffectingMaxValue;
	private boolean isPrimordial;

	public StatEnumeration getType() {
		return type;
	}

	public Stat(StatEnumeration type, int curvalue, int maxvalue) {
		this.type = type;
		curValue = curvalue;
		baseValue = curvalue;
		maxValue = maxvalue;
		isPrimordial = true;
	}

	public Stat(StatEnumeration type, int value, boolean istempstat) {
		this.type = type;
		curValue = value;
		baseValue= value;
		isAffectingMaxValue = istempstat;
		istempstat = false;
	}

	public int getBaseValue(){
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
		return isAffectingMaxValue;
	}

	public int getValueDifference() {
		return maxValue - curValue;
	}

	private int countValue(int value) {
		int setValue = 0;
		if (value > maxValue && maxValue != 0) {
			setValue = maxValue;
			return setValue;
		} else if (value < 0 && isPrimordial) {
			if (type == StatEnumeration.Health) {
				// hero rip;
			}
			return setValue;
		}
		setValue = value;
		return setValue;
	}
}
