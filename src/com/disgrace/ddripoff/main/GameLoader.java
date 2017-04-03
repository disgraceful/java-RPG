package com.disgrace.ddripoff.main;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.disgrace.ddripoff.characters.heroes.Centurion;
import com.disgrace.ddripoff.characters.heroes.Dishonored;
import com.disgrace.ddripoff.characters.heroes.Priest;
import com.disgrace.ddripoff.characters.heroes.Purifier;
import com.disgrace.ddripoff.utils.SaveHelper;

public class GameLoader {

	static Set<Object> gameData = new HashSet<>();
	private GameLoader() {
	}

	public static void loadHeroData() {
		gameData.add((Centurion) SaveHelper.loadCharFromXml("centurion", Centurion.class));
		gameData.add((Dishonored) SaveHelper.loadCharFromXml("dishonored", Dishonored.class));
		gameData.add((Priest) SaveHelper.loadCharFromXml("priest", Priest.class));
		gameData.add((Purifier) SaveHelper.loadCharFromXml("purifier", Purifier.class));
	}

	public static <T> Optional<Object> getDataAsOptional(Class<T> clazz) {
		return gameData.stream().filter(e -> e.getClass() == clazz).findAny();
	}
}
