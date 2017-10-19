package rpg.core.characters.heroes;

import java.util.Random;

import rpg.core.characters.heroes.classes.Centurion;
import rpg.core.characters.heroes.classes.Dishonored;
import rpg.core.characters.heroes.classes.Priest;
import rpg.core.characters.heroes.classes.Purifier;
import rpg.core.characters.shared.CharClass;


public enum HeroClass implements CharClass {
	CENTURION {
		@Override
		public Class<Centurion> getClassToSpawn() {
			return Centurion.class;
		}
	},
	DISHONORED {
		@Override
		public Class<Dishonored> getClassToSpawn() {
			return Dishonored.class;
		}
	},
	PRIEST {
		@Override
		public Class<Priest> getClassToSpawn() {
			return Priest.class;
		}
	},
	PURFIER {
		@Override
		public Class<Purifier> getClassToSpawn() {
			return Purifier.class;
		}
	};

	public static HeroClass getRandomValue() {
		return values()[new Random().nextInt(values().length)];
	}

}
