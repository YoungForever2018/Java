package reflect;

import java.lang.reflect.Constructor;

public class Reflect {

	public static void main(String[] args) {
		Student s = new Student();
		
		//���ַ�ʽ��ȡClass����
		Class<?> c1 = getClass(s);
		Class<?> c2 = getClass("reflect.Student");
		Class<?> c3 = Student.class;
		
		System.out.println(c1.getName()+":"+c2.getName()+":"+c3.getName());
		System.out.println(c1==c2);
		System.out.println(c1==c3);
		
		//��ȡ
		
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

class Student{
	private String name ;
	private int age;
	
	public Student(){
		
	}
	
	public Student(String name ,int age){  
	    System.out.println("������"+name+"���䣺"+ age);
	}  
	  
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}