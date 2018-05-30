package reflect;

import java.lang.reflect.Constructor;

public class ReflectConstructor {

	public static void main(String[] args) {
		Class<?> c = Reflect.getClass("reflect.Teacher");
		
		//获取所有的构造方法、构造方法参数、并打印
		Constructor<?>[] constructors = getConstructor(c, 2);
		for (Constructor<?> constructor : constructors) {
			System.out.println("constructor: "+constructor);
			
			Class<?>[] constructorParamTypes = getConstructorParamType(constructor);
			for (Class<?> cpt : constructorParamTypes) {
				System.out.println("constructorParamType: "+cpt);
			}
		}
 	}

	/**
	 * 获取构造方法
	 * @param c
	 * @param modifier = 1 获取公有构造函数(public)，
	 * 		  modifier = 2 获取所有构造函数(public,private, protected,default)。
	 * @return
	 */
	private static Constructor<?>[] getConstructor(Class<?> c,int modifier){
		Constructor<?>[] constructors = null;
		if(modifier==1){
			constructors = c.getConstructors();
		}else {
			constructors = c.getDeclaredConstructors();
		}
		return constructors;
	}
	
	/**
	 * 获取构造方法
	 * @param c
	 * @param modifier = 1 获取公有构造函数(public)，
	 * 		  modifier = 2 获取所有构造函数(public,private, protected,default)。
	 * @param parameterType 
	 */
	@SuppressWarnings("unused")
	private static Constructor<?> getConstructor(Class<?> c,int modifier, Class<?> parameterType){
		Constructor<?> constructor = null;
		try {
			if(modifier==1){
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
