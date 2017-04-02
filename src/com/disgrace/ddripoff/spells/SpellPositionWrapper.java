package com.disgrace.ddripoff.spells;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SpellPositionWrapper {

	Set<Integer> requiredPosition = new HashSet<>();

	public SpellPositionWrapper(Integer... positions) {
		requiredPosition.addAll(Arrays.asList(positions));
	}

	public SpellPositionWrapper() {

	}

	public Set<Integer> getRequiredPosition() {
		return requiredPosition;
	}

	public void setRequiredPosition(Set<Integer> requiredPosition) {
		this.requiredPosition = requiredPosition;
	}

	public boolean isPosRequired(Integer pos) {
		return requiredPosition.contains(pos);
	}
}
