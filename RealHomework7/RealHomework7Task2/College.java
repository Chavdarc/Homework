
public class College {

	public static void main(String[] args) {
		
		Student emilio = new Student();
		emilio.name = "Emilio";
		emilio.age = 22;
		emilio.grade = 4.30;
		emilio.subject = "Baking Technology Management";
		emilio.yearInCollege = 1;
		emilio.upYear();
		
		Student morenaSousa = new Student("Morena", "Baking Technology Management", 20);
		morenaSousa.grade = 4.50;
		morenaSousa.yearInCollege = 1;
		morenaSousa.receiveScholarship(4.5, 50); //checking whether she will receive scholarship with valid arguments
		System.out.printf("%s has %.2f lv. from scholarship. \n", morenaSousa.name, morenaSousa.money);
		
		Student bibiana = new Student("Bibiana", "Baking Technology Management", 19);
		bibiana.grade = 6;
		bibiana.yearInCollege = 1;
		bibiana.upYear();
		
		Student socorro = new Student("Socorro", "Baking Technology Management", 21);
		socorro.grade = 6;
		socorro.yearInCollege = 1;
		
		
		Student hernandes = new Student("Hernandes", "Electrical Engineering", 19);
		hernandes.grade = 4.49;
		hernandes.receiveScholarship(4.5, 73);//checking if scholarship will be rejected with lower GPA
		System.out.printf( "%s has %.2f lv. from scholarship. \n", hernandes.name, hernandes.money);
		
		Student dolores = new Student("Dolores", "Electrical Engineering", 23);
		dolores.grade = 5;
		dolores.yearInCollege = 3;
		System.out.println(dolores.isDegree);
		dolores.upYear();
		System.out.println(dolores.isDegree);//checking if isDegree changes after year in college is 4
		
		Student remedio = new Student("Remedio", "Electrical Engineering", 19);
		remedio.grade = 5.67;
		remedio.yearInCollege = 1;
		
		Student salvadora = new Student("Salvadora", "Electrical Engineering", 19);
		salvadora.grade = 4.51;
		salvadora.yearInCollege = 1;
		salvadora.receiveScholarship(4.5, 73);
		System.out.printf( "%s has %.2f lv. from scholarship. \n", salvadora.name, salvadora.money);
		
		Student shashaq = new Student("Shashaq", "Ethical Hackig", 30);
		shashaq.grade = 6;
		shashaq.yearInCollege = 3;
		shashaq.receiveScholarship(4.5, 73);//checking if people above 29 receive scholarship
		System.out.printf( "%s has %.2f lv. from scholarship. \n", shashaq.name, shashaq.money);
		
		Student mzwaga = new Student("Mzwaga", "Ethical Hackig", 22);
		mzwaga.grade = 5.02;
		mzwaga.yearInCollege = 3;
		
		Student ndlovu = new Student("Ndlovu", "Ethical Hackig", 21);
		ndlovu.grade = 5.60;
		ndlovu.yearInCollege = 3;
		
		Student dandada = new Student("Dandada", "Ethical Hackig", 17);
		dandada.grade = 6;
		dandada.yearInCollege = 4;
		dandada.upYear();
		dandada.receiveScholarship(5, 79);//checking if a graduated person could receive a scholarship.
		System.out.printf( "%s has %.2f lv. from scholarship. \n", dandada.name, dandada.money);
		
		StudentGroup bakingManagement = new StudentGroup("Baking Technology Management");
		
		bakingManagement.addStudent(hernandes);
		bakingManagement.addStudent(emilio);
		bakingManagement.addStudent(emilio); //checking if we can add a student twice in a group
		bakingManagement.addStudent(morenaSousa);
		bakingManagement.addStudent(bibiana);
		bakingManagement.addStudent(socorro);
		
		bakingManagement.printStudentsInGroup();
		bakingManagement.printTheBestStudent();
		
		bakingManagement.emptyGroup();
		
		bakingManagement.printStudentsInGroup();//checking the students group print for an empty group.
		bakingManagement.printTheBestStudent();//checking the best student print for an empty group.
		
		StudentGroup electrics = new StudentGroup("Electrical Engineering");
		
		electrics.addStudent(hernandes);
		electrics.addStudent(dolores);
		electrics.addStudent(remedio);
		
		electrics.printStudentsInGroup();
		electrics.printTheBestStudent();
		System.out.println("The free places in " + electrics.groupSubject + " are " + electrics.freePlaces +".");
				
	}

}
