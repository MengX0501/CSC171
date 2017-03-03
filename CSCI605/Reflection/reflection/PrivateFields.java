package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class PrivateFields extends Fields {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		for(String name: args) {
			Class<?> c = Class.forName(name);
			Object instance = c.newInstance();
			
			Field[] fields = c.getDeclaredFields();
			for(Field field : fields) {
				int mod = field.getModifiers();
				
				if(Modifier.isPrivate(mod)) {
					field.setAccessible(true);
					examineField(field, instance);
				}	
			}
		}
	}
}
