package reflection;
/**
 * 
 * Reflection : a dynamic mechanism , in a running application ,jvm can know class member info , and invoke.
 * 
 * Reflection API: Class、Method、Field、Constructor 
 * 
 * Steps of use reflection 1.get the object associated with the class or interface with the given name . for example : 
 * 					Class<?> c = Class.forName("name");
 * 			   2.create a new instance , there are three ways, for example ： 
 * 					Object o = c.newInstance();
 * 			   3.get class members and invoke .for example:
* 					Method[] methods = c.getMethods();
* 					foreach(Method method ： methods){
* 						method.invoke(o,Object...args)
* 					}
 */
public class Reflect {

	public static void main(String[] args) {
		Student s = new Student("elvis",18);
		
		//
		Class<?> c1 = getClass(s);
		Class<?> c2 = getClass("reflect.Student"); 
		Class<?> c3 = Student.class;
		
		System.out.println(c1.getName()+":"+c2.getName()+":"+c3.getName());
		System.out.println(c1==c2);
		System.out.println(c1==c3);
		
		//get instance
		try {
			//create a new instance , need default constructor
			Student s1 = (Student) c2.newInstance(); //equals  Student s1 = (Student) c2.getConstructor().newInstance();
			s1.setName("elvis");
			System.out.println(s1.getName());
			
			//crate a new instance with specified constructor 
			Student s2 = (Student) c2.getConstructor(String.class,int.class).newInstance("elvis",22);
			System.out.println(s2.getName()+":"+s2.getAge());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static Class<? extends Object> getClass(Object object){
		Class<? extends Object> c = object.getClass();
		return c;
	}
	
	
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

