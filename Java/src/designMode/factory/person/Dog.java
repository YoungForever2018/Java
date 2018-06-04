package designMode.factory.person;

public class Dog implements Animal {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void walk() {
		System.out.println("Dog walk");
	}
}
