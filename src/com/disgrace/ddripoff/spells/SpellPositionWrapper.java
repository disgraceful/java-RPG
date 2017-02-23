package com.disgrace.ddripoff.spells;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SpellPositionWrapper {

	Set<Integer>requiredPosition = new HashSet<>();
	
	public SpellPositionWrapper(Integer... positions){
		requiredPosition.addAll(Arrays.asList(positions));
	}

	public Set<Integer> getRequiredPosition() {
		return requiredPosition;
	}

	public void setRequiredPosition(Set<Integer> requiredPosition) {
		this.requiredPosition = requiredPosition;
	}
	
	public boolean isPosRequired(Integer pos){
		return requiredPosition.contains(pos);
	}
}
