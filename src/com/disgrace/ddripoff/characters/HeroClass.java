package com.disgrace.ddripoff.characters;

public enum HeroClass {
	CENTURION("Centurion"), DISHONORED("Dishonored"), PRIEST("Priest"), PURFIER("Purifier");

	private String name;

	private HeroClass(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
