package reflect;

import java.lang.reflect.Field;

public class ReflectFields {

	public static void main(String[] args) {

		Class<?> c = Reflect.getClass("reflect.Teacher");
		
		Field[] fields = c.getFields();
		Field[] declaredFields = c.getDeclaredFields();
		
		try {
			Field field = c.getField("name");
			Field declaredField = c.getDeclaredField("name");
			Object object = c.getConstructor().newInstance();
			
			declaredField.set(object, "elvis");
			
			Teacher teacher = (Teacher) object;
			teacher.getName();
			
			field.setAccessible(true);//暴力反射，解除私有限定  
			field.set(object, "18888889999");  

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	
}
