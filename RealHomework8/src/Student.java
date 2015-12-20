
class Student extends Person {
	
	private double score;
	
	
// Вариантът, в който можем да създадем Student() без параметри.
	
//	public Student() {
//		super("Tozi", 8, true);
//	}

	Student(String name, int age, boolean isMale, double score) {
		super(name, age, isMale);
		if(score < 2 || score > 6){
			System.out.println("Wrong score input.");
		}else{
			this.score = score;
		}
	}
	
	double getScore(){
		return score;
	}
	
	void setScore(double score){
		this.score = score;
	}
	
	void showStudentInfo(){
		super.showPersonInfo();
		
		System.out.println("Score: " + this.score);
		
	}
}
