
package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Methods {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for(String name: args) {
			Class<?> c = Class.forName(name);
			Object instance = c.newInstance();
			
			Method[] methods = c.getDeclaredMethods();
			for(Method method : methods) {
				int mod = method.getModifiers();
				
				if(Modifier.isPrivate(mod)) {
					System.out.println(method.getName() + " is private and can't be accessed!");
				}
				else {
					examineMethod(method, instance);
				}
			}
		}
	}
	
	public static void examineMethod(Method method, Object instance) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		System.out.println(method.getName());
		int count = method.getParameterCount();
		
		if(count > 0) {
			System.out.println("  parameter types:" );
			Class<?>[] parameters = method.getParameterTypes();
			for(Class<?> parameter : parameters) {
				System.out.println("    " + parameter);
			}
		}
		else {
			System.out.println("  no parameters");
		}
		
		Class<?> returnType = method.getReturnType();
		System.out.println( "  return type:" + returnType);
		
		Object[] args = new Object[count];
		for(int i=0; i<count; i++) {
			args[i] = new Integer(i+5);
		}
		
		Object result = method.invoke(instance, args);
		System.out.println("  method invocation result: " + result + "(" 
				+ returnType + ")");
	}
}
