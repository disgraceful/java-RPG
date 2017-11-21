package rpg.core.dungeon.events;

import rpg.core.dungeon.events.curio.Curio;
import rpg.core.dungeon.events.fight.FightType;
import rpg.core.dungeon.events.treasure.TreasureType;
import rpg.core.utils.CalcHelper;

public enum SpawnableEventType {
	FIGHT(35) {
		@Override
		public SpawnEvent getEvent() {
			SpawnEvent event = FightType.getEvent();
			event.spawn();
			return event;
		}
	},
	TREASURE(40) {
		@Override
		public SpawnEvent getEvent() {
			SpawnEvent event = TreasureType.getEvent();
			event.spawn();
			return event;
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
