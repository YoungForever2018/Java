package reflect;

public class Teacher {
	private String name ;
	private int age ;
	
	/*
	 * Constructors
	 */
	public Teacher() {
		this(18);
	}
	private Teacher(int age) {
		this.age = age;
		System.out.println(age);
	}
	protected Teacher(String name){
		this.name = name;
	}
	public Teacher(String name,int age){
		this.name = name;
		this.age = age;
		System.out.println(name + ":"+ age);
	}
	
	public Teacher(boolean b){
		System.out.println("this is a boolean method");
	}
	
	
	public String toString(){
		return "this is toString()";
	}
	
	/*
	 * getter¡¢setter
	 */
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
