package test.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import org.omg.CORBA.INTERNAL;

public class TestMethodReference {

	static ExecutorService pool = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {

		List<Runnable> list = new ArrayList<>();

		Runnable runnable = () -> System.out.println(Thread.currentThread());
		runnable = () -> {
		};
		addSameRunnableNTimesToList(list, runnable, 1000);

		compareStreams(list);

		/*
		 * for(Runnable r : list){ System.out.println(r); }
		 * 
		 * list.forEach( (r) -> System.out.println(r));
		 * 
		 * list.forEach( System.out::println);
		 */
		// before Java 8
		// oldIteration(list);

		// Using Java 8, but you will puke looking at this code
		// newIteration(list);

		// Using Java 8, and I loved it.
		coolIteration(list);

		pool.shutdown();

	}

	/**
	 * @param list
	 * @param runnable
	 */
	private static void addSameRunnableNTimesToList(List<Runnable> list,
			Runnable runnable, int n) {
		while (n-- > 0)
			list.add(runnable);
	}

	private static void coolIteration(List<Runnable> list) {

		// list.forEach( t -> pool.submit(t) );

		list.forEach(pool::submit);
	}

	private static void newIteration(List<Runnable> list) {

		list.forEach(new Consumer<Runnable>() {

			@Override
			public void accept(Runnable t) {
				pool.submit(t);
			}
		});
	}

	private static void oldIteration(List<Runnable> list) {

		Iterator<Runnable> iter = list.iterator();

		while (iter.hasNext()) {
			Runnable element = iter.next();
			pool.submit(element);

		}
	}

	private static void printIt(List<Runnable> list) {
		list.forEach((element) -> System.out.print(element + " "));
	}

	private static void compareStreams(List<Runnable> List) {

		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,10);

		long start = getTime();

		/*
		 * System.out.println(intList.parallelStream() .filter(i -> i % 2 == 0)
		 * .map(e -> e * 2) .reduce(0, Integer::sum));
		 */
		System.out.println(
				intList
				.parallelStream()
				.filter(r -> r % 2 == 0)
				.mapToInt(perform())
				.sum()
				);
		long end = getTime();

		double parallel = (end - start)/1e09;

		start = getTime();
		/*System.out.println(
				intList
				.stream()
				.filter(r -> r % 1 == 0)
				.map(r->r*2)
				.reduce(0, perform() )
				);*/
		
		end = getTime();

		double serial = (end - start)/1e09;
		System.out.println("parallel : " + parallel + " serial :" + serial
				+ "parallel < serial = " + (parallel < serial));
	}

	

	private static ToIntFunction<? super Integer> perform() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return e->e*2;
	}

	private static long getTime() {
		return System.nanoTime();
	}

}
