package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Fields {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		for(String name: args) {
			Class<?> c = Class.forName(name);
			Object instance = c.newInstance();
			
			Field[] fields = c.getDeclaredFields();
			for(Field field : fields) {
				int mod = field.getModifiers();
				
				if(Modifier.isPrivate(mod)) {
					System.out.println(field.getName() + " is private and can't be accessed!");
				}
				else {
					examineField(field, instance);
				}
			}
		}
	}
	
	public static void examineField(Field field, Object instance) throws IllegalArgumentException, IllegalAccessException {
		System.out.println(field.getType() + " " + field.getName());
		int mod = field.getModifiers();
		if(Modifier.isStatic(mod)) {
			System.out.println("  static value is: " + field.get(null));
			if(Modifier.isFinal(mod)) {
				System.out.println( "  it is final.  can't change!");
			}
			else {
				field.set(null, 123);
				System.out.println( "  value after setting: " + field.get(null));
			}
		}
		else {
			System.out.println("  value is: " + field.get(instance));
			if(Modifier.isFinal(mod)) {
				System.out.println( "  it is final.  can't change!");
			}
			else {
				field.set(instance, 456);
				System.out.println( "  value after setting: " + field.get(instance));
			}
		}
	}
}
