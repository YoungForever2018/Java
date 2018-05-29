package reflect;


public class Reflect {

	public static void main(String[] args) {
		Student s = new Student();
		
		Class<?> c1 = getClass(s);
		Class<?> c2 = getClass("reflect.Student");
		Class<?> c3 = Student.class;
		
		System.out.println(c1.getName()+":"+c2.getName()+":"+c3.getName());
		System.out.println(c1==c2);
		System.out.println(c1==c3);
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
	 * 获取Class对象
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

}

class Student{
	private String name ;
	private int age;
	
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