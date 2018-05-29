package reflect;

import java.lang.reflect.Constructor;

public class ReflectConstructor {

	public static void main(String[] args) {
		Class<?> c = Reflect.getClass("reflect.Teacher");
		
		//获取所有的公有构造方法并打印、获取构造方法的参数并打印
		Constructor<?>[] constructors = getConstructor(c, 1);
		for (Constructor<?> constructor : constructors) {
			System.out.println("constructor: "+constructor);
			
			Class<?>[] constructorParamTypes = getConstructorParamType(constructor);
			for (Class<?> cpt : constructorParamTypes) {
				System.out.println("constructorParamType: "+cpt);
			}
		}
		
		//获取单个构造方法
		Constructor<?> constructor = getConstructor(c, 1, boolean.class);
		System.out.println("");
		System.out.println("constructor: "+constructor);
		
//		constructor.setAccessible(true);
//		try {
//			Object object = constructor.newInstance();
//		} catch (Exception e) {
//		
//		}
 	}

	/**
	 * 获取构造方法
	 * @param c
	 * @param type = 1 获取公有构造函数(public)，
	 * 		  type = 2 获取所有构造函数(private , protected)。
	 * @return
	 */
	private static Constructor<?>[] getConstructor(Class<?> c,int type){
		Constructor<?>[] constructors = null;
		if(type==1){
			constructors = c.getConstructors();
		}else {
			constructors = c.getDeclaredConstructors();
		}
		return constructors;
	}
	
	/**
	 * 获取构造方法
	 * @param c
	 * @param type = 1 获取公有构造函数(public)，
	 * 		  type = 2 获取所有构造函数(public,private, protected,default)。
	 * @param parameterType 
	 */
	private static Constructor<?> getConstructor(Class<?> c,int type, Class<?> parameterType){
		Constructor<?> constructor = null;
		try {
			if(type==1){
				constructor = c.getConstructor(parameterType);
			}else{
				constructor = c.getDeclaredConstructor(parameterType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return constructor;
	}
	
	/**
	 * 获取构造方法的参数类型
	 * @param constructor
	 * @return
	 */
	private static Class<?>[] getConstructorParamType(Constructor<?> constructor){
		Class<?>[] cArray = constructor.getParameterTypes();
		return cArray;
	}
}
