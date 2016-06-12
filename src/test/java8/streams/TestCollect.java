package test.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import test.java8.utils.Utility;

public class TestCollect {
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		List<Movie> movies = Utility.createListOfMovies();

		/* printMaxUsingReduce(list); */

		// DO NOT DO THIS - SHARED MUTABILITY
		/* useForEachToCopyList(list); */

		// Correct way of handling such operations
		/* useCollectToCopyList(list); */

		useCollectToCopySet(list);

		useCollectToCreateMap(movies);
	}

	

	/**
	 * @param movies
	 */
	private static void useCollectToCreateMap(List<Movie> movies) {
		Map<String, Object> map = movies.stream()
										.collect(Collectors.toMap(m -> m.getName()
															+ " - "
															+ m.getYear(),
															m -> m));

		map.forEach((k, v) -> System.out.println("[" + k + " - " + v + "]"));
	}

	/**
	 * Handles Thread Safety for SHARED MUTABILITY Collect is again a kind of
	 * Reduce operation.
	 * 
	 * @param list
	 */
	private static void useCollectToCopySet(List<Integer> list) {

		Set<Integer> copyList = null;

		copyList = list.stream()
						.filter(n -> n % 2 == 0)
						.map(n -> n * 1)
						.collect(Collectors.toSet());

		copyList.forEach(System.out::println);
	}

	/**
	 * Do not do this because here, forEach is mutating a shared copyList
	 * object. NEVER DO SHARED MUTABILITY.
	 * 
	 * @param list
	 */
	private static void useForEachToCopyList(List<Integer> list) {
		List<Integer> copyList = new ArrayList<Integer>();

		list.stream()
			.filter(n -> n % 2 == 0)
			.map(n -> n * 2)
			.forEach(n -> copyList.add(n));

		copyList.forEach(System.out::println);

	}

	/**
	 * Handles Thread Safety for SHARED MUTABILITY Collect is again akind of
	 * Reduce operation.
	 * 
	 * @param list
	 */
	private static void useCollectToCopyList(List<Integer> list) {
		List<Integer> copyList = null;

		copyList = list.stream()
						.filter(n -> n % 2 == 0)
						.map(n -> n * 2)
						.collect(Collectors.toList());
		copyList.forEach(System.out::println);
	}

	/**
	 * @param list
	 * @return
	 */
	private static void printMaxUsingReduce(List<Integer> list) {
		Optional<Integer> max = list.stream()
									.filter(n -> n % 2 == 0)
									.map(n -> n * 1)
									.reduce((a, b) -> Integer.max(a, b));

		System.out.println(max.get());
	}
}
