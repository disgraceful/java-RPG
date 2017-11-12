package rpg.core.spawn.events;

import rpg.core.utils.CalcHelper;

public enum SpawnableEventType {
	FIGHT(35) {
		@Override
		public SpawnEvent getEvent() {
			Fight fight =(Fight) FightType.getRandomFight().getConcreteEvent();
			fight.spawnEnemyParty();
			return fight;
		}
		
		public SpawnEvent getEvent(SpawnEventParams params){
			return params.getConcreteEvent();
		}
	},
	TREASURE(40) {
		@Override
		public SpawnEvent getEvent() {
			return new Treasure();
		}

		@Override
		public SpawnEvent getEvent(SpawnEventParams param) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	CURIO(45) {
		@Override
		public Curio getEvent() {
			return new Curio();
		}

		@Override
		public SpawnEvent getEvent(SpawnEventParams param) {
			// TODO Auto-generated method stub
			return null;
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
		return values()[CalcHelper.getRandomInt(values().length)];
	}

	public abstract SpawnEvent getEvent();
	
	public abstract SpawnEvent getEvent(SpawnEventParams param);
}




