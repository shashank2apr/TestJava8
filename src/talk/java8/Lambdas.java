/**
 * @author : shashank Lambdas.java : 11-Nov-2016
 */
package talk.java8;

import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Purpose : Demonstrate following: <br>
 * - Before Lambdas. <br>
 * - What are Lambdas?
 */
public class Lambdas {

	public static void main(String[] args) {

		// Java7:Before Lambdas
		Thread oldThread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread created using Anonymous Inner class!");
			}
		});
		oldThread.start();

		// Java8:Using Lambdas
		Thread newThread = new Thread(() -> System.out.println("Thread created using Lambdas!"));
		newThread.start();

		// useOfLambdas();

	}

	/**
	 * 
	 */
	private static void useOfLambdas() {

		// Taking input from user;
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		// Test if Number is EVEN
		testNumber(n, new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t % 2 == 0;
			}
		});

		// Test if Number is ODD
		// testNumber(n, new Predicate<Integer>() {
		// @Override
		// public boolean test(Integer t) {
		// return t % 2 != 0;
		// }
		// });

		// Test if Number is POSITIVE
		// testNumber(n, new Predicate<Integer>() {
		// @Override
		// public boolean test(Integer t) {
		// return t % 2 != 0;
		// }
		// });
	}

	/**
	 * 
	 */
	private static void testNumber(Integer n, Predicate<Integer> predicate) {
		if (predicate.test(n))
			System.out.println(Boolean.TRUE);
		else
			System.out.println(Boolean.FALSE);

	}

}
