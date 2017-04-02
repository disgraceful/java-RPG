package com.disgrace.ddripoff.stats;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Stat implements Serializable {
	StatEnumeration type;
	int baseValue;
	int curValue;
	int maxValue;
	boolean isAffectingMaxValue;
	boolean isTemporary;

	public Stat(StatEnumeration type, int curvalue, int maxvalue) {
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

	public void setType(StatEnumeration type) {
		this.type = type;
	}

	public void setBaseValue(int baseValue) {
		this.baseValue = baseValue;
	}

	public void setCurValue(int curValue) {
		this.curValue = curValue;
	}

	public void setAffectingMaxValue(boolean isAffectingMaxValue) {
		this.isAffectingMaxValue = isAffectingMaxValue;
	}

	public Stat(StatEnumeration type, int value) {
		this.type = type;
		curValue = value;
		baseValue = value;
	}

	public Stat(StatEnumeration type, int curvalue, boolean isAffectingMaxValue) {
		this(type, curvalue);
		this.isAffectingMaxValue = isAffectingMaxValue;
		isTemporary = true;
	}

	public StatEnumeration getType() {
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
		} else if (value < 0 && !isTemporary) {
			return setValue;
		}
		setValue = value;
		return setValue;
	}
}
