package rpg.core.dungeon.events.fight;

import rpg.core.dungeon.events.SpawnEvent;
import rpg.core.dungeon.events.SpawnEventParams;
import rpg.core.utils.CalcHelper;

public enum FightType implements SpawnEventParams {
	TOUGH {
		@Override
		public ToughFight getConcreteEvent() {
			return new ToughFight();
		}
	},
	MID {
		@Override
		public MidFight getConcreteEvent() {
			return new MidFight();
		}
	},
	WEAK {
		@Override
		public WeakFight getConcreteEvent() {
			return new WeakFight();
		}
	},
	SPECIAL {
		@Override
		public SpecialFight getConcreteEvent() {
			return new SpecialFight();
		}
	};

	public static SpawnEvent getEvent() {
		return values()[CalcHelper.randInt(values().length - 1)].getConcreteEvent();
	}

}