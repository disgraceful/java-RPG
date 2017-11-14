package rpg.core.utils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class CalcHelper {

	private static final Logger LOG = Logger.getLogger(CalcHelper.class.getSimpleName());

	private CalcHelper() {
	}

	public static int getRandomIntInRange(int min, int max) {
		int result = ThreadLocalRandom.current().nextInt(min, max + 1);
		// LOG.info("Rand int in range of " + min + " to " + max + " = " +
		// Integer.toString(result));
		return result;
	}

	public static int calcRandomIntWithPercent(int value, double percent) {

		int result = (int) ThreadLocalRandom.current().nextDouble((value * (1 - percent)), (value * (1 + percent)) + 1);
		// LOG.info("Rand int from " + value + " within " + -percent + " to " +
		// percent + " range = "+ Integer.toString(result));
		return result;
	}

	public static int randInt(int bound) {
		int result = ThreadLocalRandom.current().nextInt(bound);
		// LOG.info("Rand int up to " + bound + " = " +
		// Integer.toString(result));
		return result;
	}

	public static int calcApproxInt(int coreElement, List<Integer> ints) {
		int min = Integer.MAX_VALUE;
		int closest = coreElement;

		for (int v : ints) {
			final int diff = Math.abs(v - coreElement);
			if (diff < min) {
				min = diff;
				closest = v;
			}
		}
		return closest;
	}

}
