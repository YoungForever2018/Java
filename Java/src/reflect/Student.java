package reflect;

public class Student {
	
	private String name ;
	private int age;
	
	public Student(){
		
	}
	
	public Student(String name ,int age){  
	    System.out.println(name+" £º"+ age);
	}  
	  
	
	public void talk(String content){
		System.out.println(content);
	}
	
	public void talk(String content1,String content2){
		System.out.println(content1 +":"+content2);
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
