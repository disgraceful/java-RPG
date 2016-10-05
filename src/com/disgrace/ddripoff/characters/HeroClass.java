package com.disgrace.ddripoff.characters;

import java.util.ArrayList;
import java.util.Random;

public enum HeroClass {
	CENTURION("Centurion"), DISHONORED("Dishonored"), PRIEST("Priest"), PURFIER("Purifier");

	private String name;
	private final static Random RANDOM = new Random();
	public static final ArrayList<HeroClass> VALUES = new ArrayList<HeroClass>() {
		{
			add(HeroClass.CENTURION);
			add(HeroClass.DISHONORED);
			add(HeroClass.PRIEST);
			add(HeroClass.PURFIER);
		}
	};
	private static final int SIZE = VALUES.size();

	private HeroClass(String name) {
		this.name = name;
	}

	

	public static HeroClass getRandomValue() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}

	@Override
	public String toString() {
		return name;
	}

}
