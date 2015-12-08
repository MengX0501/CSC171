package reflection;

public class Loader {
	public static void main(String[] args) throws ClassNotFoundException {
		for(String name : args ) {
			Class<?> c = Class.forName(name);
			System.out.println(c);
		}
	}
}
