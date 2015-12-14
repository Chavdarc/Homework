
public class StudentGroup {
	
	String groupSubject;
	Student[] students;
	int freePlaces;
	
	
	StudentGroup() {
		students = new Student[5];
		freePlaces = 5;
	}
	
	StudentGroup(String subject){
		this();
		this.groupSubject = subject;
	}
	
	void addStudent(Student a){
		if(a.subject == this.groupSubject && freePlaces > 0 && !a.inGroup){
			students[freePlaces - 1] = a;
			freePlaces--;
			a.inGroup = true;
		}else if(a.inGroup){
			System.out.println(a.name + " is already in the group.");
		}else{
			System.out.println( a.name + " cannot be a part of this group.");
		}
	}
	
	void emptyGroup(){
		students = new Student[5];
		freePlaces = 5;
	}
	
	String[] theBestStudent(){
		int bestStudentsCount = 0;
		String[] bestStudents = new String[1];
		
		if(students[students.length - 1] != null){
			Student bestStudent = students[students.length - 1];
			
			for(int i = students.length - 2; i >= 0; i--){
				if(students[i] != null){
					if(students[i].grade > bestStudent.grade  ){
						bestStudent = students[i];
					}
				}
			}
			for(int i = students.length - 1; i >= 0; i--){
				if(students[i] != null){
					if(students[i].grade == bestStudent.grade  ){
						bestStudentsCount++;
					}
				}
			}
			
			bestStudents = new String[bestStudentsCount];
			
			if(bestStudentsCount == 1){
				bestStudents[bestStudentsCount - 1] = bestStudent.name;
				return bestStudents;
			}else{
				for(int i = students.length - 1; i >= 0; i--){
					if(students[i] != null){
						if(students[i].grade == bestStudent.grade  ){
							bestStudents[bestStudentsCount - 1] = students[i].name;
							bestStudentsCount--;
						}
					}
				}
				return bestStudents;
			}
		}else{
			bestStudents[0] = "noone as " + this.groupSubject + " group is currently empty and students need to be added";
			return bestStudents;
		}
		
	}
	
	void printStudentsInGroup(){
		int studentsCount = 0;
		for(int i = 0; i < students.length; i++){
			if(students[i] != null){
				System.out.println("Student: " + students[i].name);
				System.out.println("Age: " + students[i].age);
				System.out.printf("GPA: %.2f \n", students[i].grade);
				System.out.println("Year in college: " + students[i].yearInCollege + "\n");
				studentsCount++;
			}
		}
		if(studentsCount == 0){
			System.out.println("The group has no students added yet.");
		}
	}
	
	void printTheBestStudent(){
		String[] theBestStudents = this.theBestStudent();
		
		if(theBestStudents.length == 1){
			System.out.println("The best student in " + this.groupSubject + " is " + theBestStudents[0] + ".");
		}else{
			System.out.print("The best students in " + this.groupSubject + " are: ");
			for(int i = 0; i < theBestStudents.length; i++){
				if(i == theBestStudents.length - 1){
					System.out.println("and " + theBestStudents[i] + ".");
				}else if(i == theBestStudents.length - 2){
					System.out.print(theBestStudents[i] + " ");
				}else{
					System.out.print(theBestStudents[i] + ", ");
				}
			}
		}
	}

}
