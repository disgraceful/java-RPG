package com.disgrace.ddripoff.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.disgrace.ddripoff.session.GameSession;

public class SaveHelper {
	private static final Logger LOG = Logger.getLogger(SaveHelper.class.getSimpleName());
	private static final String PROJ_PATH = System.getProperty("user.dir");
	private static final String SAVES_PATH = PROJ_PATH + "/saves/";

	private SaveHelper() {

	}

	public static void save(Object obj, String userName) {
		try (FileOutputStream fos = new FileOutputStream(SAVES_PATH + userName.toLowerCase() + ".ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			LOG.fine("saving works");
			oos.writeObject(obj);

		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error when saving to file.", e);
		}
	}

	public static GameSession load(String userName) {
		try (FileInputStream fis = new FileInputStream(SAVES_PATH + userName.toLowerCase() + ".ser");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			LOG.fine("laoding works");
			return (GameSession) ois.readObject();
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error when loading to file.", e);
		}
		return null;
	}

	public static List<File> getActiveUsers() {
		return Arrays.asList(new File(SAVES_PATH).listFiles());
	}

	public static List<String> getActiveUsersAsString() {
		List<String> users = new ArrayList<>();
		getActiveUsers().stream().forEach(e -> users.add(e.getName()));
		return users;
	}
}
