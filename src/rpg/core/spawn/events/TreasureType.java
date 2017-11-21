package rpg.core.spawn.events;

public enum TreasureType implements SpawnEventParams {
	SMALL_TREASURE {
		@Override
		public SpawnEvent getConcreteEvent() {
			return new SmallTreasure();
		}
	},
	MID_TREASURE {
		@Override
		public SpawnEvent getConcreteEvent() {
			return new MidTreasure();
		}
	},
	LARGE_TREASURE {
		@Override
		public SpawnEvent getConcreteEvent() {
			return null;
		}
	};
}
