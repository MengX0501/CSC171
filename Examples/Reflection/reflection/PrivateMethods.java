package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrivateMethods extends Methods {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for(String name: args) {
			Class<?> c = Class.forName(name);
			Object instance = c.newInstance();
			
			Method[] methods = c.getDeclaredMethods();
			for(Method method : methods) {
				int mod = method.getModifiers();
				
				if(Modifier.isPrivate(mod)) {
					method.setAccessible(true);
					examineMethod(method, instance);
				}
			}
		}
	}
}
