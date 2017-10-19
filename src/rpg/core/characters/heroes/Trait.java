package rpg.core.characters.heroes;

import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatWrapper;

public class Trait {
	private String name;
	private boolean locked;
	private StatWrapper stats;

	public Trait(StatWrapper stats) {
		this.stats = stats;
	}

	public Trait(Stat... stat) {
		stats = new StatWrapper(stat);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StatWrapper getStats() {
		return stats;
	}

	public void setStats(StatWrapper stats) {
		this.stats = stats;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

}
