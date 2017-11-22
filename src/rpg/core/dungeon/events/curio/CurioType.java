package rpg.core.dungeon.events.curio;

import rpg.core.dungeon.events.SpawnEvent;
import rpg.core.dungeon.events.SpawnEventParams;
import rpg.core.utils.CalcHelper;

public enum CurioType implements SpawnEventParams {
	CORRUPTED_FOUNTAIN {
		@Override
		public SpawnEvent getConcreteEvent() {
			return new CorruptedFountain();
		}
	},
	HOLY_ALTAR {
		@Override
		public SpawnEvent getConcreteEvent() {
			return new HolyAltar();
		}
	},
	TRAPPED_MECHANISM {
		@Override
		public SpawnEvent getConcreteEvent() {
			return new TrappedMechanism();
		}
	};

	@Override
	public SpawnEvent getRandomizedEvent() {
		return values()[CalcHelper.randInt(values().length)].getConcreteEvent();
	}
}
