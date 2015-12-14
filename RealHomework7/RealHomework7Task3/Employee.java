
public class Employee {
	
	private String name;
	private Task currentTask = new Task();
	private int hoursLeft;
	
	public Employee(String name) {
		if((name.equals("")) || name.matches(".*\\d+.*" ) || name.equals(" ") || name.trim().length() < 2){
			System.out.println("Invalid input. Only letters are allowed when defining a name of an employee.");
		}else{
			this.name = name;
		}
	}
	
	public String getName(){
		return name;
	}
	
	public Task getCurrentTask(){
		return currentTask;
	}
	
	public void setCurrentTask(Task currentTask){
		this.currentTask = currentTask;
	}
	
	public int getHoursLeft(){
		return hoursLeft;
	}
	
	public void setHoursLeft(int hoursLeft){
		if(hoursLeft < 0){
			System.out.println("Invalid hours input");
		}else{
			this.hoursLeft = hoursLeft;
		}
	}
	
	void work(){
		if(this.currentTask.getName() != null && this.getCurrentTask().getHours() > 0 && this.getName() != null){
			if(this.currentTask.getHours() > this.getHoursLeft()){
				this.currentTask.setHours(this.currentTask.getHours() - this.getHoursLeft());
				this.setHoursLeft(0);
			}else{
				this.setHoursLeft(this.getHoursLeft() - this.currentTask.getHours());
				this.currentTask.setHours(0);
			}
			showReport();
		}else if(this.currentTask.getName() == null && this.getCurrentTask().getHours() <= 0){
			System.out.println("Please assign a task that has not been finished to the employee first.");
		}
	}
	
	private void showReport(){
		System.out.println("Task Report");
		System.out.println("The employee name: " + this.getName());
		System.out.println("The employee task: " + this.getCurrentTask().getName());
		System.out.println("The hours left on the task: " + this.getCurrentTask().getHours());
		System.out.println("The employee's working hours left for the day: " + this.getHoursLeft());
	}
}
