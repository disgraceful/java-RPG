package rpg.core.dungeon.events.curio;

import java.util.Arrays;
import java.util.List;

import rpg.core.dungeon.DungeonType;
import rpg.core.dungeon.events.SpawnEvent;
import rpg.core.dungeon.events.SpawnEventParams;
import rpg.core.utils.CalcHelper;
import rpg.core.utils.StreamUtils;

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

	private static List<CurioType> values = Arrays.asList(values());

	@Override
	public SpawnEvent getRandomizedEvent() {
		return values.get(CalcHelper.randInt(values().length)).getConcreteEvent();
	}

	public static SpawnEvent getRandomEventByRestriction(DungeonType restriction) {
		return StreamUtils
				.getRandomItemFromStream(
						values
						.stream()
						.filter(e -> e.getConcreteEvent().getAreaRestriction().contains(restriction)))
				.getConcreteEvent();
	}
}
