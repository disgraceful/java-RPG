package rpg.core.dungeon.events;

import rpg.core.utils.CalcHelper;

public enum SpawnableEventType {
	FIGHT(35), TREASURE(40), CURIO(45);

	private int chance;

	private SpawnableEventType(int chance) {
		this.chance = chance;
	}

	public int getChance() {
		return chance;
	}

	public static SpawnableEventType getRandomValue() {
		return values()[CalcHelper.randInt(values().length)];
	}

}
