/**
 * @author : shashank TestBiFunctions.java : 18-Aug-2016
 */
package test.java8.higherorderfunctions;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Purpose :
 */
public class TestBiFunctions {

	static Chooser customBiFunction(char A, char Z) {
		return new Chooser() {
			@Override
			public boolean isIn(char c) {
				return c <= Z && c >= A;
			}
		};
	}

	public static void main(String[] args) {

		String sentence = "jUu";

		BiFunction<Character, Character, Chooser> biFunction = (A, Z) -> c -> c >= A && c <= Z;

		Chooser newChooser = biFunction.apply('a', 'z');
		for (char c : sentence.toCharArray()) {
			if (customBiFunction('a', 'z').isIn(c)) {
				System.out.print("From BiFunction : " + c);
			}
		}

		Function<Character, Chooser> function = a -> c -> c == a;

		for (char c : sentence.toCharArray()) {
			if (function.apply('e').isIn(c)) {
				// System.out.println("From function : " + c);
			}
		}

		// preJ8way(sentence);
	}

	/**
	 * @param sentence
	 */
	private static void preJ8way(String sentence) {
		Chooser chooser = c -> c >= 'a' && c <= 'z';

		for (char c : sentence.toCharArray()) {
			if (((Chooser) (a -> a >= 'q' && a <= 'x')).isIn(c)) {
				System.out.print(c);
			}
		}

	}
}

@FunctionalInterface
interface Chooser {
	boolean isIn(char c);
}

class CapitalChooser implements Chooser {
	/*
	 * (non-Javadoc)
	 * @see test.java8.higherorderfunctions.Chooser#isIn(char)
	 */
	@Override
	public boolean isIn(char c) {
		return c >= 'A' && c <= 'Z';
	}
}