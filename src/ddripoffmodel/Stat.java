package ddripoffmodel;

public class Stat {
	private String name;
	private int curValue;
	private int maxValue;
	private boolean isAffectingMaxValue;

	public String getName() {
		return name;
	}

	public Stat(String name, int curvalue, int maxvalue) {
		this.name = name;
		this.curValue = curvalue;
		this.maxValue = maxvalue;
	}

	public Stat(String name, int value, boolean istempstat) {
		this.name = name;
		this.curValue = value;
		this.isAffectingMaxValue = istempstat;
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

	public int getHpDifference(){
		return maxValue - curValue;
	}
	
	private int countValue(int value) {
		int setValue = 0;
		if (value > maxValue && !isAffectingMaxValue) {
			setValue = maxValue;
			return setValue;

		} else if (value < 0 && !isAffectingMaxValue) {
			if (name == "Health") {
				// hero rip;
			}
			return setValue;
		}
		setValue = value;
		return setValue;
	}
}
