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

	private SaveHelper() {

	}

	public static void saveToBin(Object obj, String userName) {
		try (FileOutputStream fos = new FileOutputStream(SAVES_PATH + userName.toLowerCase() + ".ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			LOG.fine("saving works");
			oos.writeObject(obj);

		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error when saving to bin.", e);
		}
	}

	public static void saveToXml(Object obj, String userName) {
		try {

			File file = new File(SAVES_PATH + userName.toLowerCase() + ".xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(obj, file);
			jaxbMarshaller.marshal(obj, System.out);

		} catch (JAXBException e) {
			LOG.log(Level.SEVERE, "Error when saving to xml.", e);
		}
	}

	public static Object loadFromBin(String userName) {
		try (FileInputStream fis = new FileInputStream(SAVES_PATH + userName.toLowerCase() + ".ser");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			LOG.fine("laoding works");
			return ois.readObject();
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error when loading bin file.", e);
		}
		return null;
	}

	public static <T> Object loadFromXml(String userName, Class<T> clazz) {
		try {
			File file = new File(SAVES_PATH + userName.toLowerCase() + ".xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return jaxbUnmarshaller.unmarshal(file);

		} catch (JAXBException e) {
			LOG.log(Level.SEVERE, "Error when loading xml file.", e);
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
