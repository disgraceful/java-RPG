package rpg.core.utils;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUtils {

	private StreamUtils() {

	}
	public static <T> T getRandomItemFromStream(Stream<T> stream) {
		return stream
				.collect(Collectors.collectingAndThen(Collectors.toList(), 
						collected -> {
							Collections.shuffle(collected);
							return collected.stream();
						}))
				.findAny()
				.get();
	}
}
