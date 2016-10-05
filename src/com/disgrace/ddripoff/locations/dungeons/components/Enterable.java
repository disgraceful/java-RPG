package com.disgrace.ddripoff.locations.dungeons.components;

public interface Enterable {
	void enter();
	void leave();
	void goTo(Enterable room);
}
