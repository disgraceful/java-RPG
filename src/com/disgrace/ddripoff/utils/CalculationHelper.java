package com.disgrace.ddripoff.utils;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class CalculationHelper {

	private static final Logger LOG = Logger.getLogger(CalculationHelper.class.getSimpleName());

	private CalculationHelper() {
	}

	public static int getRandomIntInRange(int min, int max) {
		int result = ThreadLocalRandom.current().nextInt(min, max + 1);
		LOG.info("Rand int in range of " + min + " to " + max + " = " + Integer.toString(result));
		return result;
	}

	public static int calcRandomIntWithPercent(int value, double percent) {

		int result = ThreadLocalRandom.current().nextInt((int) (value * (1 - percent)),
				(int) (value * (1 + percent)) + 1);
		LOG.info("Rand int from " + value + " within " + -percent + " to " + percent + " range = "
				+ Integer.toString(result));
		return result;
	}

	public static int getRandomInt(int bound) {

		int result = ThreadLocalRandom.current().nextInt(bound);
		LOG.info("Rand int up to  " + bound + " = " + Integer.toString(result));
		return result;
	}
}
