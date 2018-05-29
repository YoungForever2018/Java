package reflect;

import java.lang.reflect.Constructor;

public class ReflectConstructor {

	public static void main(String[] args) {
		Class<?> c = Reflect.getClass("reflect.Teacher");
		
		//��ȡ���еĹ��й��췽������ӡ����ȡ���췽���Ĳ�������ӡ
		Constructor<?>[] constructors = getConstructor(c, 1);
		for (Constructor<?> constructor : constructors) {
			System.out.println("constructor: "+constructor);
			
			Class<?>[] constructorParamTypes = getConstructorParamType(constructor);
			for (Class<?> cpt : constructorParamTypes) {
				System.out.println("constructorParamType: "+cpt);
			}
		}
		
		//��ȡ�������췽��
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
	 * ��ȡ���췽��
	 * @param c
	 * @param type = 1 ��ȡ���й��캯��(public)��
	 * 		  type = 2 ��ȡ���й��캯��(private , protected)��
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
	 * ��ȡ���췽��
	 * @param c
	 * @param type = 1 ��ȡ���й��캯��(public)��
	 * 		  type = 2 ��ȡ���й��캯��(public,private, protected,default)��
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
	 * ��ȡ���췽���Ĳ�������
	 * @param constructor
	 * @return
	 */
	private static Class<?>[] getConstructorParamType(Constructor<?> constructor){
		Class<?>[] cArray = constructor.getParameterTypes();
		return cArray;
	}
}
