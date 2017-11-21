package rpg.core.spawn.events;

import rpg.core.utils.CalcHelper;

public enum SpawnableEventType {
	FIGHT(35) {
		@Override
		public SpawnEvent getEvent() {
			Fight fight = (Fight) FightType.getRandomFight().getConcreteEvent();
			fight.spawn();
			return fight;
		}
	},
	TREASURE(40) {
		@Override
		public SpawnEvent getEvent() {
			return new Treasure();
		}
	},
	CURIO(45) {
		@Override
		public Curio getEvent() {
			return new Curio();
		}
	};

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

	public abstract SpawnEvent getEvent();

	public SpawnEvent getEvent(SpawnEventParams params) {
		return params.getConcreteEvent();
	}
}
