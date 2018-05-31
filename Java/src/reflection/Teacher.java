package reflection;

public class Teacher {
	private String name ;
	private int age ;
	public String sex ;
	
	/*
	 * Constructors
	 */
	public Teacher() {
		this(18);
	}
	
	private Teacher(int age) {
		this("elvis");
		this.age = age;
	}
	
	protected Teacher(String name){
		this.name = name;
	}
	
	public Teacher(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public Teacher(boolean b){
		System.out.println("this is a boolean method");
	}
	
	/*
	 * methods
	 */
	public String say(){
		return "hello";
	}
	
	public String talk(String str){
		System.out.println(str);
		return str;
	}
	
	public String toString(){
		System.out.println(this.name + ":" + this.age);
		return null;
	}
	
	/*
	 * getter setter
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
	
	/*
	 * main method
	 */
	public static void main(String[] args){
		System.out.println("main method");
	}
}
