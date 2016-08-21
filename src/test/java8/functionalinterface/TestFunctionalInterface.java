package test.java8.functionalinterface;

public class TestFunctionalInterface {

	public static void main(String[] args) {

		SumFunctionalInterface i = (x, y) -> System.out.println(x + y);
		i.perform(40, 30);
	}

}
