package reflection;

public class Polymorphism {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		for(String name : args) {
			Class<?> c = Class.forName(name);
			
			if(ExampleInterface.class.isAssignableFrom(c)) {
				ExampleInterface ei = (ExampleInterface)c.newInstance();
				ei.speak();
			}
			else {
				System.out.println("Class does not implement the interface: " + c.getName());
			}
		}
	}
}
