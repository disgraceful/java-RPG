package rpg.core.dungeon.events.fight;

import java.util.Arrays;
import java.util.List;

import rpg.core.dungeon.DungeonType;
import rpg.core.dungeon.events.SpawnEvent;
import rpg.core.dungeon.events.SpawnEventParams;
import rpg.core.utils.CalcHelper;

public enum FightType implements SpawnEventParams {
	TOUGH {
		@Override
		public ToughFight getConcreteEvent() {
			return new ToughFight();
		}

		@Override
		public SpawnEvent getEventWithRestriction(DungeonType restriction) {
			return new ToughFight(restriction);
		}
	},
	MID {
		@Override
		public MidFight getConcreteEvent() {
			return new MidFight();
		}

		@Override
		public SpawnEvent getEventWithRestriction(DungeonType restriction) {
			return new MidFight(restriction);
		}
	},
	WEAK {
		@Override
		public WeakFight getConcreteEvent() {
			return new WeakFight();
		}

		@Override
		public SpawnEvent getEventWithRestriction(DungeonType restriction) {
			return new WeakFight(restriction);
		}
	};

	private static List<FightType> values = Arrays.asList(values());

	private FightType getRandomElement() {
		return values.get(CalcHelper.randInt(values().length - 1));
	}

	@Override
	public SpawnEvent getRandomizedEvent() {
		return getRandomElement().getConcreteEvent();
	}

	public abstract SpawnEvent getEventWithRestriction(DungeonType restriction);

	public SpawnEvent getRandomizedEvent(DungeonType restriction) {
		return getRandomElement().getEventWithRestriction(restriction);
	}
}