

public class TaskDemo {
	
//	Да се създаде програма в която се създава обект от клас AllWork, който 	се запълва
//	със задачи(10-12 задачи) с различно време. Да се създадът и няколко (3-4) работника.
//	В един безкраен цикъл, да се даде старт на 	работата и всички работници да започнат
//	да си теглят задачи и да работят по тях. Всяка итерация на цикъла е 1 ден в офиса и
//	приключва когато всичките работници си изработят 8те часа за деня.

	public static void main(String[] args) {
		
		int day = 1;
		Employee grigor = new Employee("Grigor");
		Employee stefan = new Employee("Stefan");
		Employee fabio = new Employee("     ");
		
		AllWork christmasCards = new AllWork();
		
		Task buyPresents = new Task("Get some presents", 11);
		Task buyGiftCards = new Task("Get some gift cards", 5);
		Task buyWrappingPaper = new Task("Get some wrapping paper", 7);
		Task getGiftBoxes = new Task("Get some gift boxes for the presents", 3);
		Task fillWishCards = new Task("Write good Christmas wishes on the cards", 9);
		Task assaignGiftsToPeople = new Task("Assaign which present is going to whom", 5);
		Task sizeWrappingPaper = new Task("Size the wrapping paper according to the size of the gifts", 14);
		Task putPresentsInBoxes = new Task("Put the presents in the gift boxes that were bought", 11);
		Task runForTheChristmasTree = new Task("     ", 5);
		Task wrapThePresents = new Task("Wrap the presents with the wrapping paper", 5);
		Task presentUnderTheTree = new Task("Put the presents udner the tree", 11);
		
		christmasCards.addTask(buyPresents);
		christmasCards.addTask(buyGiftCards);
		christmasCards.addTask(buyWrappingPaper);
		christmasCards.addTask(fillWishCards);
		christmasCards.addTask(getGiftBoxes);
		christmasCards.addTask(assaignGiftsToPeople);
		christmasCards.addTask(sizeWrappingPaper);
		christmasCards.addTask(putPresentsInBoxes);
		christmasCards.addTask(runForTheChristmasTree);
		runForTheChristmasTree.setName("Go and buy the Christmas tree!");
		christmasCards.addTask(wrapThePresents);
		christmasCards.addTask(presentUnderTheTree);
		
		Employee.setAllwork(christmasCards);
		
		while(true){
			
			System.out.println("Start of working day " + day);
			
			grigor.startWorkingDay();
			stefan.startWorkingDay();
			fabio.startWorkingDay();
			
			grigor.work();
			stefan.work();
			fabio.work();
			
			if(grigor.getCurrentTask() != null){
				System.out.println(grigor.getName() + " is working on task : " + grigor.getCurrentTask().getName());
			}
			
			if(stefan.getCurrentTask() != null){
				System.out.println(stefan.getName() + " is working on task : " + stefan.getCurrentTask().getName());
			}
			if(fabio.getCurrentTask() != null){
				System.out.println(fabio.getName() + " is working on task : " + fabio.getCurrentTask().getName());
			}
			
			while((grigor.getHoursLeft() > 0 && grigor.getCurrentTask() != null) 
					|| (stefan.getHoursLeft() > 0 && stefan.getCurrentTask() != null)
					|| (fabio.getHoursLeft() > 0 && fabio.getCurrentTask() != null)){
				
				if(grigor.getHoursLeft() > 0 && grigor.getCurrentTask() != null ){
					System.out.println(grigor.getName() + " has finished on task : " + grigor.getCurrentTask().getName());
					grigor.work();
					if(grigor.getCurrentTask() != null){
						System.out.println(grigor.getName() + " is now working on task : " + grigor.getCurrentTask().getName());
					}
				}
				
				if(stefan.getHoursLeft() > 0 && stefan.getCurrentTask() != null){
					System.out.println(stefan.getName() + " has finished on task : " + stefan.getCurrentTask().getName());
					stefan.work();
					if(stefan.getCurrentTask() != null){
						System.out.println(stefan.getName() + " is now working on task : " + stefan.getCurrentTask().getName());
					}
				}
				
				if(fabio.getHoursLeft() > 0 && fabio.getCurrentTask() != null){
					System.out.println(fabio.getName() + " has finished on task : " + fabio.getCurrentTask().getName());
					fabio.work();
					if(fabio.getCurrentTask() != null){
						System.out.println(fabio.getName() + " is now working on task : " + fabio.getCurrentTask().getName());
					}
				}
				if(christmasCards.isAllWorkDone()){
					break;
				}
			}
			
			if(grigor.getCurrentTask() != null && grigor.getCurrentTask().getWorkingHours() == 0){
				System.out.println(grigor.getName() + " has finished on task : " + grigor.getCurrentTask().getName());
			}
			
			if(stefan.getCurrentTask() != null && stefan.getCurrentTask().getWorkingHours() == 0){
				System.out.println(stefan.getName() + " has finished on task : " + stefan.getCurrentTask().getName());
			}
			if(fabio.getCurrentTask() != null && fabio.getCurrentTask().getWorkingHours() == 0){
				System.out.println(fabio.getName() + " has finished on task : " + fabio.getCurrentTask().getName());
			}
			
			if(christmasCards.isAllWorkDone()){
				break;
			}
			day++;
		}
		
		System.out.println("The whole work was done on day " + day);
		
	}

}
