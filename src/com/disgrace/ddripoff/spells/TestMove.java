package com.disgrace.ddripoff.spells;

import javax.xml.bind.annotation.XmlRootElement;

import com.disgrace.ddripoff.stats.Stat;
import com.disgrace.ddripoff.stats.StatEnumeration;
import com.disgrace.ddripoff.stats.StatWrapper;

@XmlRootElement
public class TestMove extends Move{

	public TestMove() {
		description = "Description: Pushes target up to 2 units forward!";
		effectStats = new StatWrapper(new Stat(StatEnumeration.MOVE_SPELL_POSITION, +2),new Stat(StatEnumeration.MOVE_CHANCE,150));
	}
}
