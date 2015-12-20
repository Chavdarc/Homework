//И един въпрос, какво ще стане ако дефинирате конструктор без параметри Student() в класа
//Student? Възможно ли е, и ако не защо. Как може да се оправи това?

// Тъй като суперкласа Person няма дефиниран конструктор по подразбиране, то не е възможно
// да създадем констурктор по подразниране за негов подклас. С изключение на случаят 
// в който в тялото на Student() извикаме съществуващ конструктор на суперкласа 
// с подавайки му определени аргументи. Това извикване трябва да бъде направен на първият
// ред след фигурната скоба. 

public class Demo {

	public static void main(String[] args) {
		
		Person[] people = new Person[10];
		
		Person gabriela = new Person("Gabriela", 21, false);
		Person ana = new Person("Ana", 17, false);
		Student joao = new Student("Joao", 26, true, 5.4);
		Student thais = new Student("Thais", 15, true, 3.4);
		Employee gustavo = new Employee("Gustavo", 19, true, 99);
		Employee jessica = new Employee("Jessica", 16, false, 65.82);
		
		people[0] = gabriela;
		people[1] = ana;
		people[2] = joao;
		people[3] = thais;
		people[4] = gustavo;
		people[5] = jessica;
		
		for(int i = 0; i < people.length; i++){
			if(people[i] != null){
				if(people[i] instanceof Employee){
					((Employee) people[i]).showEmplyeeInfo();
				}else if(people[i] instanceof Student){
					((Student) people[i]).showStudentInfo();
				}else{
					people[i].showPersonInfo();
				}
			}
				
		}
		
		for(int i = 0; i < people.length; i++){
			if(people[i] != null){
				if(people[i] instanceof Employee){
					System.out.print(people[i].getName() + " will receive ");
					System.out.printf("%.2f$ from overtime. \n", ((Employee) people[i]).calculateOvertime(3));
				}
			}
				
		}
		
	}

}
