package rpg.core.dungeon.events.treasure;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import rpg.core.dungeon.events.SpawnEvent;
import rpg.core.dungeon.events.SpawnEventParams;
import rpg.core.utils.CalcHelper;

public enum TreasureType implements SpawnEventParams {
	
	SMALL_TREASURE(100) {
		@Override
		public SpawnEvent getConcreteEvent() {
			return new SmallTreasure();
		}
	},
	MID_TREASURE(45) {
		@Override
		public SpawnEvent getConcreteEvent() {
			return new MidTreasure();
		}
	},
	LARGE_TREASURE(10) {
		@Override
		public SpawnEvent getConcreteEvent() {
			return null;
		}
	};

	private int occurance;
	private static List<TreasureType> values = Arrays.asList(values());

	private TreasureType(int occurance) {
		this.occurance = occurance;
	}

	public int getOccurance() {
		return occurance;
	}

	public static SpawnEvent getEvent() {
		int approxOccurance = CalcHelper.calcIndexBeforeSelected(CalcHelper.randInt(101),
				values.stream().map(e -> e.getOccurance()).collect(Collectors.toList()));
		return getEventByOccurance(approxOccurance);
	}

	public static SpawnEvent getEventByOccurance(int occurance) {
		return values.stream().filter(e -> e.getOccurance() == occurance).findFirst().get().getConcreteEvent();
	}
}
