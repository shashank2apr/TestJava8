/**
 * @author : shashank Lambdas.java : 11-Nov-2016
 */
package talk.java8;

/**
 * Purpose : Demonstrate following: <br>
 * - Before Lambdas. <br>
 * - What are Lambdas?
 */
public class Lambdas {

	public static void main(String[] args) {

		// final is effective below
		String outer = "Outer";
		//outer = outer.substring(2);
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(outer);
			}
		}).start();
	}

}
