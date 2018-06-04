package designMode.factory.person;

public class TestAnimalFactory {

	public static void main(String[] args) {
		walk("Dog");
	}
	
	public static void walk(String className) {
		Animal animal = new AnimalFactory().getInstance(className);
		animal.walk();
	}
}
