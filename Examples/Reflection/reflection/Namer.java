package reflection;

public class Namer {
	public static void main(String[] args) throws ClassNotFoundException {		
		for(String name : args ) {
			Class<?> c = Class.forName(name);
			System.out.println(c.getName());
			System.out.println(c.getCanonicalName());
			System.out.println(c.getSimpleName());
			System.out.println();
		}
	}
}
