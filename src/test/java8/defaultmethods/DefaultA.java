package test.java8.defaultmethods;

public interface DefaultA {
	public void m();
	
	default public void defMethod(){
		System.out.println("DefaultA"+getClass().getCanonicalName());
	}

	
}
