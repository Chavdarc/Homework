
public class Employee extends Person{
	
	private double dailySalary;
	
	Employee(String name, int age, boolean isMale, double dailySalary) {
		super(name, age, isMale);
		if(dailySalary <= 0){
			System.out.println("Wrong daily salary amount input.");
		}else{
			this.dailySalary = dailySalary;
		}
	}
	
	double getDailySalary(){
		return dailySalary;
	}
	
	void setDailySalary(double dailySalary){
		if(dailySalary <= 0){
			System.out.println("Wrong daily salary amount input.");
		}else{
			this.dailySalary = dailySalary;
		}
	}
	
	double calculateOvertime(double hours){
		if(this.getAge() < 18 || hours <= 0){
			return 0;
		}else{
			return hours*(this.dailySalary / 8);
		}
	}
	
	void showEmplyeeInfo(){
		super.showPersonInfo();
		
		System.out.printf("Daily salary: %.2f \n", dailySalary);
		
	}
	
}
