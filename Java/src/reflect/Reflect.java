package reflect;

import java.lang.reflect.Constructor;
/**
 * Java反射机制：Java是非动态语言，但反射机制是一个动态相关的机制。
 * 				在程序运行时对任意一个类JVM可以知道其属性和方法、生成类的实例、调用其属性和方法。
 * 				(动态语言是程序运行时可以改变结构，如引进新的方法、删除已有方法，JavaScript)
 * 
 * 反射API: Class、Method、Field、Constructor 
 * 
 * 使用反射的步骤：1.获取类的Class对象：3种方式
 * 				  2.创建类的实例：2种方式
 * 				  3.调用Class对象的方法获取类的成员信息 并操作		
 */
public class Reflect {

	public static void main(String[] args) {
		Student s = new Student("elvis",18);
		
		//三种方式获取Class对象 ,class.forName("reflect.Student")最常用
		Class<?> c1 = getClass(s);
		Class<?> c2 = getClass("reflect.Student"); 
		Class<?> c3 = Student.class;
		
		System.out.println(c1.getName()+":"+c2.getName()+":"+c3.getName());
		System.out.println(c1==c2);
		System.out.println(c1==c3);
		
		//两种方式创建对象实例 
		try {
			//第一种需要类有默认的构造器
			Student s1 = (Student) c2.newInstance(); //equals  Student s1 = (Student) c2.getConstructor().newInstance();
			s1.setName("elvis");
			System.out.println(s1.getName());
			
			//第二种根据选定的构造方法获得
			Student s2 = (Student) c2.getConstructor(String.class,int.class).newInstance("elvis",22);
			System.out.println(s2.getName()+":"+s2.getAge());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 获取Class对象
	 * @param object
	 * @return
	 */
	public static Class<? extends Object> getClass(Object object){
		Class<? extends Object> c = object.getClass();
		return c;
	}
	
	/**
	 * 获取Class对象，常用
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
		//获取构造方法
		Constructor<?>[] constructors = c.getConstructors();
		for(Constructor<?> constructor :constructors){
			System.out.println(constructor);
		}
	}
}

