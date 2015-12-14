
public class TaskDemo {

	public static void main(String[] args) {
		
		
		Task carryToTheTop = new Task();
		System.out.println(carryToTheTop.getName());//empty task
		System.out.println(carryToTheTop.getHours());//default hours value 0
		carryToTheTop.setHours(-3);//checking if validation for hours work
		carryToTheTop.setName("Name33");
		System.out.println(carryToTheTop.getName());//name validation works
		
		carryToTheTop.setHours(7);
		carryToTheTop.setName("Carry all the bags to the top of Burj Khalifa.");
		System.out.println();
		
		
		Employee chung = new Employee("Chung Zhao");
		
		chung.setHoursLeft(-1);//checking if hours validation works
		System.out.println();
		
		chung.setHoursLeft(6);
		chung.setCurrentTask(carryToTheTop);
		chung.work();
		System.out.println();
		
		Task bagsBack = new Task("Get all the bags down from the top of Burj Khalifa.", 7);
		Employee ho = new Employee("Ho Xu Sun");
		ho.setCurrentTask(bagsBack);
		ho.setHoursLeft(14);
		ho.work();

	}

}
