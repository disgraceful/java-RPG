package com.disgrace.ddripoff.characters;

public enum HeroClass {
	CENTURION,
	DISHONORED,
	PRIEST,
	PURFIER;
	
	@Override public String toString(){
		return this.getClass().toString();
	}
}
