package reflection;

import java.lang.reflect.Constructor;
/**
 * Java������ƣ�Java�ǷǶ�̬���ԣ������������һ����̬��صĻ��ơ�
 * 				�ڳ�������ʱ������һ����JVM����֪�������Ժͷ������������ʵ�������������Ժͷ�����
 * 				(��̬�����ǳ�������ʱ���Ըı�ṹ���������µķ�����ɾ�����з�����JavaScript)
 * 
 * ����API: Class��Method��Field��Constructor 
 * 
 * ʹ�÷���Ĳ��裺1.��ȡ���Class����3�ַ�ʽ
 * 				  2.�������ʵ����2�ַ�ʽ
 * 				  3.����Class����ķ�����ȡ��ĳ�Ա��Ϣ ������		
 */
public class Reflect {

	public static void main(String[] args) {
		Student s = new Student("elvis",18);
		
		//���ַ�ʽ��ȡClass���� ,class.forName("reflect.Student")���
		Class<?> c1 = getClass(s);
		Class<?> c2 = getClass("reflect.Student"); 
		Class<?> c3 = Student.class;
		
		System.out.println(c1.getName()+":"+c2.getName()+":"+c3.getName());
		System.out.println(c1==c2);
		System.out.println(c1==c3);
		
		//���ַ�ʽ��������ʵ�� 
		try {
			//��һ����Ҫ����Ĭ�ϵĹ�����
			Student s1 = (Student) c2.newInstance(); //equals  Student s1 = (Student) c2.getConstructor().newInstance();
			s1.setName("elvis");
			System.out.println(s1.getName());
			
			//�ڶ��ָ���ѡ���Ĺ��췽�����
			Student s2 = (Student) c2.getConstructor(String.class,int.class).newInstance("elvis",22);
			System.out.println(s2.getName()+":"+s2.getAge());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * ��ȡClass����
	 * @param object
	 * @return
	 */
	public static Class<? extends Object> getClass(Object object){
		Class<? extends Object> c = object.getClass();
		return c;
	}
	
	/**
	 * ��ȡClass���󣬳���
	 * @param className
	 * @return
	 */
	public static Class<?> getClass(String className){
		Class<?> c = null;
		try {
			c = Class.forName(className);
		} catch (ClassNotFoundException e) {
			System.out.println("load failed!");
		}
		return c;
	}

	public static void getConstructors(){
		Class<?> c = getClass("reflect.Student");
		//��ȡ���췽��
		Constructor<?>[] constructors = c.getConstructors();
		for(Constructor<?> constructor :constructors){
			System.out.println(constructor);
		}
	}
}

