package designMode.factory.person;

public class AnimalFactory {
public Animal getInstance(String className){
	if(className==null){
		return null;
	}
	
	if(className.equalsIgnoreCase("Person")){
		return new Person();
	}else if (className.equalsIgnoreCase("Dog")){
		return new Dog();
	}else if (className.equalsIgnoreCase("Cat")){
		 return new Cat();
	}
	return null;
}
}
