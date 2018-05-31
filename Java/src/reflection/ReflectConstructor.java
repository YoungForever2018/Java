package reflection;

import java.lang.reflect.Constructor;

public class ReflectConstructor {

	public static void main(String[] args) {
		Class<?> c = Reflect.getClass("reflect.Teacher");
		
		//��ȡ���еĹ��췽�������췽������������ӡ
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
	 * ��ȡ���췽��
	 * @param c
	 * @param modifier = 1 ��ȡ���й��캯��(public)��
	 * 		  modifier = 2 ��ȡ���й��캯��(public,private, protected,default)��
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
	 * ��ȡ���췽��
	 * @param c
	 * @param modifier = 1 ��ȡ���й��캯��(public)��
	 * 		  modifier = 2 ��ȡ���й��캯��(public,private, protected,default)��
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
	 * ��ȡ���췽���Ĳ�������
	 * @param constructor
	 * @return
	 */
	private static Class<?>[] getConstructorParamType(Constructor<?> constructor){
		Class<?>[] cArray = constructor.getParameterTypes();
		return cArray;
	}
}
