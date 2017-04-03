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

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class SaveHelper {
	private static final Logger LOG = Logger.getLogger(SaveHelper.class.getSimpleName());
	private static final String PROJ_PATH = System.getProperty("user.dir");
	private static final String SAVES_PATH = PROJ_PATH + "/saves/";
	private static final String CHAR_PATH = PROJ_PATH + "/chars/";
	private static final String EXTRA_PATH = PROJ_PATH + "/extras/";

	private SaveHelper() {
	}

	private static void saveToXml(Object obj, File output) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(obj, output);
			jaxbMarshaller.marshal(obj, System.out);
		} catch (JAXBException e) {
			LOG.log(Level.SEVERE, "Error when saving to xml.", e);
		}
	}

	public static void saveUserToXml(Object obj, String userName) {
		File file = new File(SAVES_PATH + userName.trim().toLowerCase() + ".xml");
		saveToXml(obj, file);
	}

	public static void saveCharToXml(Object obj, String charName) {
		File file = new File(CHAR_PATH + charName.trim().toLowerCase() + ".xml");
		saveToXml(obj, file);
	}

	public static void saveToExtrasToXml(Object obj, String fileName) {
		File file = new File(EXTRA_PATH + fileName.trim().toLowerCase() + ".xml");
		saveToXml(obj, file);
	}

	private static <T> Object loadFromXml(File source, Class<T> clazz) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return jaxbUnmarshaller.unmarshal(source);

		} catch (JAXBException e) {
			LOG.log(Level.SEVERE, "Error when loading xml file.", e);
		}
		return null;
	}

	public static <T> Object loadUserFromXml(String userName, Class<T> clazz) {
		File file = new File(SAVES_PATH + userName.toLowerCase() + ".xml");
		return loadFromXml(file, clazz);
	}
	public static <T> Object loadCharFromXml(String charName, Class<T> clazz) {
		File file = new File(CHAR_PATH + charName.toLowerCase() + ".xml");
		return loadFromXml(file, clazz);
	}
	public static <T> Object loadExtraFromXml(String fileName, Class<T> clazz) {
		File file = new File(EXTRA_PATH + fileName.toLowerCase() + ".xml");
		return loadFromXml(file, clazz);
	}

	public static List<File> getActiveUsers() {
		return Arrays.asList(new File(SAVES_PATH).listFiles());
	}

	public static List<String> getActiveUsersAsString() {
		List<String> users = new ArrayList<>();
		getActiveUsers().stream().forEach(e -> users.add(e.getName()));
		return users;
	}
	
	public static Object loadFromBin(File source) {
		try (FileInputStream fis = new FileInputStream(source);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			LOG.fine("laoding works");
			return ois.readObject();
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error when loading bin file.", e);
		}
		return null;
	}
	
	public static void saveToBin(Object obj, File output) {
		try (FileOutputStream fos = new FileOutputStream(output);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(obj);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error when saving to bin.", e);
		}
	}
}
