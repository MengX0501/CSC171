package reflected;

import java.io.Serializable;

import reflection.ExampleInterface;

@SuppressWarnings("unused")
public class ExampleClass extends ExampleSuper implements Serializable, ExampleInterface {
	
	private static final long serialVersionUID = 1L;
	
	public static int PUBLIC_STATIC_FIELD = 1;
	public static final int PUBLIC_STATIC_FINAL_FIELD = 2;
	private static final int PRIVATE_STATIC_FINAL_FIELD = 3;
	
	public int PUBLIC_FIELD = 4;
	private int PRIVATE_FIELD = 5;
		

	@Override
	public void speak() {
		System.out.println("Hi, there!");		
	}
	
	public String echoAString(int echo) {
		return Integer.toString(echo);
	}
	
	public float addAllTogether(int x, int y, float c) {
		return x + y + c;
	}
	
	private static String getAStaticString() {
		return "A STATIC TRING!";
	}
	
	private void whisper() {
		System.out.println("Pssst!");
	}
	
	public class ExampleInnerClass {
		
	}
}
