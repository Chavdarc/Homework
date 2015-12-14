
public class Student {
	
	String name;
	String subject;
	double grade;
	int yearInCollege;
	int age; 
	boolean isDegree;
	double money;
	boolean inGroup;
	
	
	Student() {
		this.grade = 4.0;
		this.yearInCollege = 1;
		this.isDegree = false;
		this.money = 0;
		
	}
	
	Student(String name, String subject, int age){
		this();
		this.name = name;
		this.subject = subject;
		this.age = age;
	}
	
	void upYear(){
		if(yearInCollege >= 4){
			System.out.println(this.name + " has already graduated.");
			isDegree = true;
		}else{
			yearInCollege++;
			if(yearInCollege == 4){
				isDegree = true;
			}
		}
	}
	
	double receiveScholarship(double min, double amount){
		if(this.grade >= min && age < 30 && !isDegree){
			this.money += amount;
			return this.money;
		}else{
			return this.money;
		}
	}

}
