package test.java8.closures;
public class TestEffectiveFinal {
	public void print(String str) {
		System.out.println("Method printing : " + str);
	}
	public static void main(String[] args) {
		
		String outer = "Outer";
	
		new Thread(   ()-> System.out.println(outer)	).start();
		
		
		/*new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(outer);
			}
		}).start();*/

	}


}
