package test.java8.defaultmethods;

public class TestDefaultMethods extends DefaultSuperClass implements DefaultA,DefaultB {

	public static void main(String[] args) {
		
		new TestDefaultMethods().defMethod();
		
	}

	@Override
	public void m() {
	
		
	}
	/*
	@Override
	public void defMethod(){
		DefaultA.super.defMethod();
	}
*/
}
