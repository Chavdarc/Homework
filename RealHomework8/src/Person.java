
public class Person {
	
	private String name;
	private int age;
	private boolean isMale;
	
	
	protected Person(String name, int age, boolean isMale){
		if(name.matches(".*\\d+.*" ) || name.trim().length() < 2){
			System.out.println("Wrong name input.");
		}else{
			this.name = name;
		}
		
		if(age <= 0){
			System.out.println("Invalid age input.");
		}else{
			this.age = age;
		}
		
		this.isMale = isMale;
	}
	
	String getName(){
		return name;
	}
	
	int getAge(){
		return age;
	}
	
	boolean getIsMale(){
		return isMale;
	}
	
	void showPersonInfo(){
		System.out.println("Name: " + this.name + "\nAge: " + this.age + "\n" +(isMale ? "Male" : "Female"));
		
		
	}
	
	@Override
	public String toString(){
		return "Name: " + this.name + "\nAge: " + this.age + "\n" +(isMale ? "Male" : "Female");
	}

}
