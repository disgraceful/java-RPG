package ddripoffmodel;

public class Stat {
	private String name;
	private int curValue;
	private int maxValue;

	public String getName() {
		return name;
	}

	public Stat(String name, int curvalue, int maxValue) {
		this.name = name;
		this.curValue = curvalue;
		this.maxValue = maxValue;
	}

	public Stat(String name, int value) {
		this.name = name;
		this.curValue = value;
	}

	public int getCurValue() {
		return curValue;
	}

	public void setValue(int value) {
		if (value > maxValue) {
			curValue = this.maxValue;
		} else if (value < 0) {
			curValue = 0;
		} else {
			curValue = value;
		}
	}
}
