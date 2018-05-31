package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectMethod {

	public static void main(String[] args) {
		Class<?> c = Reflect.getClass("reflect.Teacher");
		Method[] methods = getMethod(c, 2);
		for (Method method : methods) {
			System.out.print("method:"+method.getName()+":");

			Class<?>[] types = getMethodParamType(method);
			if(types.length == 0){
				System.out.println("no param");
			}
			
			for (Class<?> type : types) {
				System.out.println("type-" +type);
			}
		}
		
		try {
			//invoke specified method
			Object object = c.getConstructor().newInstance();
			Method method = c.getMethod("talk", java.lang.String.class);
			method.invoke(object, "hi");
			
			//invoke main method 
			Method mainMethod = c.getMethod("main", String[].class);
			mainMethod.invoke(object, (Object)new String[]{"a","b"});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static Method[] getMethod(Class<?> c , int modifier){
		Method[] methods  = null;
		if(modifier == 1){
			methods = c.getMethods();
		}else if(modifier ==2){
			methods = c.getDeclaredMethods();
		}
		return methods;
	}
	

	public static Method getMethod(Class<?> c , String name , int modifier){
		Method field = null;
		try {
			if(modifier == 1){
				field = c.getMethod(name, java.lang.String.class);
			}else if(modifier ==2){
				field = c.getDeclaredMethod(name, java.lang.String.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return field;
	}
	
	/**
	 * @return Parameters' Type
	 */
	public static Class<?>[] getMethodParamType(Method method) {
		Class<?>[] types = method.getParameterTypes();
		return types;
	}
	
	public static void getMethodParam(Method method) {
		Parameter[] parameters = method.getParameters();
		for (Parameter parameter : parameters) {
			System.out.println(parameter.getName());
			System.out.println(parameter.getModifiers());
			
		}
	}
}
