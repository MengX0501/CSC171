package reflection;

public class Inheritance {
	public static void main(String[] args) throws ClassNotFoundException {
		for(String name: args) {
			Class<?> c = Class.forName(name);
			
			System.out.println("The class: " + c.getName());
			Class<?> superClass = c.getSuperclass();
			System.out.println("The super: " + superClass.getName());
			Class<?>[] interfaces = c.getInterfaces();
			for(Class<?> i : interfaces) {
				System.out.println("implements: " + i.getName());
			}
			System.out.println();
		}
	}
}
