package com.disgrace.ddripoff.locations.dungeons.components;

public interface Enterable {
	void enter();
	void leave();
	//ArrayList<Enterable> getNeighbours();
	//void displayNeighbours();
	boolean canGoTo(Enterable e);
}
