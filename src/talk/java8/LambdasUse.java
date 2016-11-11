/**
 * @author : shashank LambdasUse.java : 11-Nov-2016
 */
package talk.java8;

import java.util.Arrays;
import java.util.List;

/**
 * Purpose :
 */
public class LambdasUse {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		numbers.forEach(System.out::print);

		// System.out.println(numbers.stream().reduce(0, (total, e) ->
		// LambdasUse.sum(total, e)));
		// System.out.println(numbers.stream().reduce(0, LambdasUse::sum));
	}

	/**
	 * 
	 */
	private static int sum(int... a) {
		int sum = 0;
		for (int element : a)
			sum += element;
		return sum;
	}

}
